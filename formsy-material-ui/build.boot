(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(def +lib-version+ "0.5.3")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "formsy-material-ui-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/formsy-material-ui
       :version     +version+
       :description "A Formsy compatibility wrapper for Material-UI form components."
       :url         "https://github.com/mbrookes/formsy-material-ui"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/mbrookes/formsy-material-ui/archive/%s.zip" +lib-version+))

(deftask download-formsy-material-ui []
         (download :url url
                   :checksum "876fdbd79990166a78dcd436249cd056"
                   :unzip true))

(def webpack-file-name "webpack.config.js")

(defn get-file [fileset file-name]
      (io/file
        (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
        file-name))

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
        ((sh "npm" "install"))
        ((sh "npm" "install" "webpack"))
        ((sh "npm" "run" "build"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
   (comp
     (download-formsy-material-ui)
     (build)
     (sift :move {#".*formsy-material-ui.js" "cljsjs/formsy-material-ui/development/formsy-material-ui.inc.js"})
     (sift :include #{#"^cljsjs"})

     (minify :in  "cljsjs/formsy-material-ui/development/formsy-material-ui.inc.js"
             :out "cljsjs/formsy-material-ui/production/formsy-material-ui.min.inc.js")

     (deps-cljs :name "cljsjs.formsy-material-ui" :requires ["cljsjs.react"
                                                             "cljsjs.react.dom"
                                                             "cljsjs.formsy-react"
                                                             "cljsjs.material-ui"])
     (pom)
     (jar)))
