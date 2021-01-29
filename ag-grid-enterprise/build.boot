(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/ag-grid-community "25.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[clojure.java.io :as io])

(def +lib-version+ "25.0.1")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "ag-grid-%s/packages/ag-grid-enterprise" +lib-version+))

(task-options!
 pom {:project     'cljsjs/ag-grid-enterprise
      :version     +version+
      :description "The JavaScript Datagrid for Enterprise"
      :url         "http://ag-grid-enterprise.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
  (download :url (format "https://github.com/ag-grid/ag-grid/archive/v%s.zip" +lib-version+)
            :unzip true))

(deftask package []
  (comp
   (download-lib)
   (sift :move {#".*dist/ag-grid-enterprise.js" "cljsjs/ag-grid-enterprise/development/ag-grid-enterprise.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/ag-grid-enterprise/development/ag-grid-enterprise.inc.js"
           :out "cljsjs/ag-grid-enterprise/production/ag-grid-enterprise.min.inc.js"
           :lang :ecmascript5)
   (deps-cljs :name "cljsjs.ag-grid-enterprise"
              :requires ["cljsjs.ag-grid-community"])
   (pom)
   (jar)
   (validate-checksums)))
