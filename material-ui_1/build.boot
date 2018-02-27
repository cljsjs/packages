(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "16.2.0-3"]
                  [cljsjs/react-dom "16.2.0-3"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "1.0.0-beta.33")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/material-ui
       :version     +version+
       :description "A Set of React Components that Implement Google's Material Design"
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(defn get-file [fileset file-name]
  (io/file
    (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
    file-name))

(deftask build-material-ui []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap fileset
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (doseq [f ["package.json" "main.js" "main-icons.js"]]
        (io/copy (get-file fileset f) (io/file tmp f)))
      (binding [boot.util/*sh-dir* (str (io/file tmp))]
        (do ((sh "npm" "install" "--include-dev"))
            ((sh "npm" "run" "build:dev"))
            ((sh "npm" "run" "build:dev-icons"))
            ((sh "npm" "run" "build:prod"))
            ((sh "npm" "run" "build:prod-icons"))
            ((sh "rm" "-rf" "./node_modules"))))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (build-material-ui)
   (sift :move {#".*material-ui.inc.js"               "cljsjs/material-ui/development/material-ui.inc.js"
                #".*material-ui-svg-icons.inc.js"     "cljsjs/material-ui/development/material-ui-svg-icons.inc.js"
                #".*material-ui.min.inc.js"           "cljsjs/material-ui/production/material-ui.min.inc.js"
                #".*material-ui-svg-icons.min.inc.js" "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"
                })
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (pom)
   (jar)))
