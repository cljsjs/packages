(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/pixi "4.5.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh *sh-dir*]])

(def +lib-version+ "0.9.16")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (str "react-pixi-" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-pixi
       :version     +version+
       :description "Create/control a Pixi.js canvas using React"
       :url         "https://github.com/Izzimach/react-pixi"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask download-zip []
  (download
   :url (str "https://github.com/Izzimach/react-pixi/archive/v" +lib-version+ ".zip")
   :checksum "ad0f7bff0dd218cfcb1dce67a86b5fe9"
   :unzip true))

(deftask build []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
       (io/file tmp "build/webpack.config.js")
       (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-zip)
   (build)
   (sift :move {#"^react-pixi-(.*)/build/react-pixi.js$"
                "cljsjs/react-pixi/development/react-pixi.inc.js"})
   (minify :in  "cljsjs/react-pixi/development/react-pixi.inc.js"
           :out "cljsjs/react-pixi/production/react-pixi.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-pixi" :requires ["cljsjs.pixi"])
   (pom)
   (jar)))
