(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/preact "7.1.0-0"]
                  [cljsjs/proptypes "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[clojure.java.io :as io])

(def +lib-version+ "3.17.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/preact-compat
       :version     +version+
       :description "React compatibility layer for Preact."
       :url         "https://preactjs.com"
       :scm         {:url "https://github.com/developit/preact-compat"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask npm-build []
  (let [tmp (boot/tmp-dir!)
        +lib-folder+ (str "preact-compat-" +lib-version+)]
    (with-pre-wrap fileset
      (doseq [f (boot/input-files fileset)
              :let [target (io/file tmp (boot/tmp-path f))]]
        (io/make-parents target)
        (io/copy (boot/tmp-file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install" "--ignore-scripts"))
        ((sh "npm" "run" "build")))
      (-> fileset (boot/add-resource (io/file tmp +lib-folder+ "dist")) boot/commit!))))

(deftask package []
  (comp
    (download :url (str "https://github.com/developit/preact-compat/archive/" +lib-version+ ".zip")
              :unzip true)
    (npm-build)
    (sift :move {#"preact-compat\.js"      "cljsjs/preact-compat/development/preact-compat.inc.js"
                 #"preact-compat\.min\.js" "cljsjs/preact-compat/production/preact-compat.min.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps\.cljs"})
    (pom)
    (jar)))
