(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.7.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/material-components
      :version     +version+
      :description "Modular and customizable Material Design UI components for the web"
      :url         "https://github.com/material-components/material-components-web"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask build-material-components []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "material-components-web-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "run" "dist")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
   (download :url (str "https://github.com/material-components/material-components-web/archive/v" +lib-version+ ".zip")
             :checksum "02d0870d024be6114b9bd1e098c1f396"
             :unzip true)

   (build-material-components)

   (sift :move {(re-pattern (str "^material-components-web-" +lib-version+ "/build/material-components-web.js$")) "cljsjs/material-components/development/material-components.inc.js"})
   (sift :move {(re-pattern (str "^material-components-web-" +lib-version+ "/build/material-components-web.css$")) "cljsjs/material-components/development/material-components.inc.css"})
   (sift :move {(re-pattern (str "^material-components-web-" +lib-version+ "/build/material-components-web.min.js$")) "cljsjs/material-components/production/material-components.min.inc.js"})
   (sift :move {(re-pattern (str "^material-components-web-" +lib-version+ "/build/material-components-web.min.css$")) "cljsjs/material-components/production/material-components.min.inc.css"})
   (sift :move {(re-pattern (str "^material-components-web-" +lib-version+ "/packages/([^/]*)/([^/]*).scss$"))
                "cljsjs/material-components/development/packages/$1/$2.scss"})

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.material-components")
   (pom)
   (jar)))
