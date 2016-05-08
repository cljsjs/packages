(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.15.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "material-ui-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/material-ui
       :version     +version+
       :description "A Set of React Components that Implement Google's Material Design"
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(def url (format "https://github.com/callemall/material-ui/archive/v%s.zip" +lib-version+))

(deftask download-material-ui []
         (download :url url
                   :checksum "0453463bdd1f55f52938a500b59ed073"
                   :unzip true))

(def main-file-name "main.js")
(def webpack-file-name "webpack.config.js")

(defn get-file [fileset file-name]
      (io/file
        (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
        file-name))

(deftask build-material-ui []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap
                fileset
                (doseq [f (->> fileset boot/input-files)
                        :let [target (io/file tmp (tmpd/path f))]]
                       (io/make-parents target)
                       (io/copy (tmpd/file f) target))
                (io/copy (get-file fileset main-file-name)
                         (io/file tmp +lib-folder+ main-file-name))
                (io/copy (get-file fileset webpack-file-name)
                         (io/file tmp +lib-folder+ webpack-file-name))
                (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
                         (do ((sh "npm" "install"))
                             ((sh "npm" "install" "webpack"))
                             ((sh "npm" "run" "build"))
                             ((sh "./node_modules/.bin/webpack"))
                             ((sh "./node_modules/.bin/webpack" "--production"))
                             ((sh "./node_modules/.bin/webpack" "--svg-icons"))
                             ((sh "./node_modules/.bin/webpack" "--svg-icons" "--production"))
                             ((sh "rm" "-rf" "./node_modules"))))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download-material-ui)
           (build-material-ui)
           (sift :move {#".*material-ui.inc.js"
                        "cljsjs/material-ui/development/material-ui.inc.js"
                        #".*material-ui-svg-icons.inc.js"
                        "cljsjs/material-ui/development/material-ui-svg-icons.inc.js"
                        #".*material-ui.min.inc.js"
                        "cljsjs/material-ui/production/material-ui.min.inc.js"
                        #".*material-ui-svg-icons.min.inc.js"
                        "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"
                        })
           (sift :include #{#"^cljsjs" #"^deps.cljs"})
           (pom)
           (jar)))