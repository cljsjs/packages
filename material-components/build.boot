(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [dosh]])

(def +lib-version+ "0.13.0")
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
        (dosh "npm" "install")
        (dosh "npm" "run" "dist"))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
   (download :url (str "https://github.com/material-components/material-components-web/archive/v" +lib-version+ ".zip")
             :checksum "b0a844d7b19a5e936a1628c43c9fb1a4"
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
