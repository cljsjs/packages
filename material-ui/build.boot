(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/react "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.14.4")
(def +version+ (str +lib-version+ "-11"))
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
                   :checksum "d8f3cd5c50e7e9e5c6530545e5a629aa"
                   :unzip true))

(def webpack-config-name "webpack.config.js")

(defn webpack-file [fileset]
      (io/file
        (:dir (first (filter #(= (:path %) webpack-config-name) (boot/user-files fileset))))
        webpack-config-name))

(deftask build-material-ui []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap
                fileset
                (doseq [f (->> fileset boot/input-files)
                        :let [target (io/file tmp (tmpd/path f))]]
                       (io/make-parents target)
                       (io/copy (tmpd/file f) target))
                (io/copy (webpack-file fileset)
                         (io/file tmp +lib-folder+ webpack-config-name))
                (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
                         (do ((sh "npm" "install"))
                             ((sh "npm" "install" "webpack"))
                             ((sh "./node_modules/.bin/webpack" "--display-error-details"))
                             ((sh "./node_modules/.bin/webpack" "--display-error-details" "--svg-icons"))))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download-material-ui)
           (build-material-ui)
           (sift :move {#".*material-ui.inc.js"
                        "cljsjs/material-ui/development/material-ui.inc.js"
                        #".*material-ui.min.inc.js"
                        "cljsjs/material-ui/production/material-ui.min.inc.js"
                        #".*material-ui-svg-icons.inc.js"
                        "cljsjs/material-ui/development/material-ui-svg-icons.inc.js"
                        #".*material-ui-svg-icons.min.inc.js"
                        "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"
                        })
           (sift :include #{#"^cljsjs" #"^deps.cljs"})
           (pom)
           (jar)))