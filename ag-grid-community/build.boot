(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [dosh]]
         '[clojure.java.io :as io])

(def +lib-version+ "19.0.0")
(def +lib-checksum+ "D904467925A64A9E000A57F471C59CDF")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "ag-grid-community-%s" +lib-version+))

(defn- dosh-cmd [& args]
  (apply dosh (if (re-find #"^Windows" (.get (System/getProperties) "os.name"))
                (into ["cmd.exe" "/c"] args)
                args)))

(defn- path [x]
  (.toString (java.nio.file.Paths/get x (into-array String nil))))

(task-options!
 pom {:project     'cljsjs/ag-grid-community
      :version     +version+
      :description "The JavaScript Datagrid for Enterprise"
      :url         "http://ag-grid.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
  (download :url (format "https://github.com/ceolter/ag-grid/archive/%s.zip" +lib-version+)
            :checksum +lib-checksum+
            :unzip true))

(deftask package []
  (comp
   (download-lib)
   (sift :move {#".*ag-grid-community/dist/ag-grid-community.js"            "cljsjs/ag-grid-community/development/ag-grid-community.inc.js"
                #".*ag-grid-community/dist/styles/ag-grid.css"              "cljsjs/ag-grid-community/development/ag-grid.inc.css"
                #".*ag-grid-community/dist/styles/compiled-icons.css"       "cljsjs/ag-grid-community/development/compiled-icons.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-balham.css"      "cljsjs/ag-grid-community/development/ag-theme-balham.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-balham-dark.css" "cljsjs/ag-grid-community/development/ag-theme-balham-dark.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-blue.css"        "cljsjs/ag-grid-community/development/ag-theme-blue.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-bootstrap.css"   "cljsjs/ag-grid-community/development/ag-theme-bootstrap.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-dark.css"        "cljsjs/ag-grid-community/development/ag-theme-dark.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-fresh.css"       "cljsjs/ag-grid-community/development/ag-theme-fresh.inc.css"
                #".*ag-grid-community/dist/styles/ag-theme-material.css"    "cljsjs/ag-grid-community/development/ag-theme-material.inc.css"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/ag-grid-community/development/ag-grid-community.inc.js"
           :out "cljsjs/ag-grid-community/production/ag-grid-community.min.inc.js"
           :lang :ecmascript5)

   (minify :in "cljsjs/ag-grid-community/development/ag-grid.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-grid.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/compiled-icons.inc.css"
           :out "cljsjs/ag-grid-community/production/compiled-icons.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-balham.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-balham.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-balham-dark.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-balham-dark.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-blue.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-blue.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-bootstrap.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-bootstrap.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-dark.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-dark.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-fresh.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-fresh.min.inc.css")
   (minify :in "cljsjs/ag-grid-community/development/ag-theme-material.inc.css"
           :out "cljsjs/ag-grid-community/production/ag-theme-material.min.inc.css")
   (deps-cljs :name "cljsjs.ag-grid-community")
   (pom)
   (jar)))
