(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "3.0.0")

(task-options!
 pom  {:project     'cljsjs/enzyme
       :version     +lib-version+
       :description "A JavaScript Testing utility for React that makes it easier to assert, manipulate, and traverse your React Components' output."
       :url         "http://airbnb.io/enzyme/"
       :scm         {:url "https://github.com/airbnb/enzyme"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn- cmd [x]
  (cond-> x
    (re-find #"^Windows" (.get (System/getProperties) "os.name")) (str ".cmd")))

(defn- path [x]
  (.toString (java.nio.file.Paths/get x (into-array String nil))))

(deftask build []
  (let [tmp (boot/tmp-dir!)
        ;; +lib-folder+ (str "enzyme-" +lib-version+)
        +lib-folder+ "."]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
        (io/file tmp "build/webpack.config.js")
        (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (io/copy
        (io/file tmp "build/helper.js")
        (io/file tmp +lib-folder+ "helper.js"))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh (cmd "npm") "install" "--production"))
        ((sh (cmd "npm") "install" "react@15" "react-dom@15" "react-test-renderer@15" "enzyme" "webpack" "enzyme-adapter-react-15"))
        ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/webpack"))) "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download :url (str "http://registry.npmjs.org/enzyme/-/enzyme-" +lib-version+ ".tgz")
              :checksum "336CA77636B5EE30B1FECA1ED1644626"
              :decompress true)
    (build)
    (sift :move {#"^enzyme.bundled.js" "cljsjs/enzyme/development/enzyme.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.enzyme")
    (pom)
    (jar)))
