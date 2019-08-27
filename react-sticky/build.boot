(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/prop-types "15.6.0-0"]
                  [cljsjs/react "15.6.2-0"]
                  [cljsjs/react-dom "15.6.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.2")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-sticky-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-sticky
       :version     +version+
       :description "React component for creating fixed and sticky DOM elements."
       :url         "https://github.com/captivationsoftware/react-sticky"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/captivationsoftware/react-sticky/archive/%s.zip" +lib-version+))

(deftask download-react-sticky []
  (download :url url
            :unzip true))

(def webpack-file-name "webpack.config.js")

(deftask build []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
       (io/file tmp "webpack.config.js")
       (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install" "--ignore-scripts"))
        ((sh "npm" "run" "clean"))
        ((sh "npm" "run" "compile"))
        ((sh "npm" "install" "webpack"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-react-sticky)
    (build)
    (sift :move {#".*/react-sticky.inc.js" "cljsjs/react-sticky/development/react-sticky.inc.js"})
    (sift :include #{#"^cljsjs"})

    (minify :in  "cljsjs/react-sticky/development/react-sticky.inc.js"
            :out "cljsjs/react-sticky/production/react-sticky.min.inc.js")

    (deps-cljs :name "cljsjs.react-sticky"
               :requires ["cljsjs.prop-types" "cljsjs.react" "cljsjs.react.dom"])
    (pom)
    (jar)
    (validate)))

