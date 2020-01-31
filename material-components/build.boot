(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [dosh]])

(def +lib-version+ "0.34.1")
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
        ;; Material-components uses Lerna which is quite stupid and presumes
        ;; that the project being built MUST BE a git repository: https://github.com/lerna/lerna/issues/555
        (dosh "git" "init")
        (dosh "npm" "install")
        ;; postinstall should run this, but doesn't
        (dosh "./node_modules/.bin/lerna" "bootstrap")
        (dosh "npm" "run" "dist"))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
   (download :url (str "https://github.com/material-components/material-components-web/archive/v" +lib-version+ ".zip")
             :unzip true)

   (build-material-components)

   (sift :move {#"^material-components-web-[^/]*/build/material-components-web.js$"      "cljsjs/material-components/development/material-components.inc.js"
                #"^material-components-web-[^/]*/build/material-components-web.js.map$"     "cljsjs/material-components/development/material-components-web.js.map"
                #"^material-components-web-[^/]*/build/material-components-web.css$"     "cljsjs/material-components/development/material-components.inc.css"
                #"^material-components-web-[^/]*/build/material-components-web.min.js$"  "cljsjs/material-components/production/material-components.min.inc.js"
                #"^material-components-web-[^/]*/build/material-components-web.min.css$" "cljsjs/material-components/production/material-components.min.inc.css"
                #"^material-components-web-[^/]*/packages/([^/]*)/([^/]*).scss$"         "cljsjs/material-components/development/packages/$1/$2.scss"})

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.material-components")
   (pom)
   (jar)
   (validate)))
