(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/ag-grid-community "25.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[clojure.java.io :as io])

(def +lib-version+ "25.0.1")
(def +version+ (str +lib-version+ "-1"))
(def +lib-folder+ (format "ag-grid-%s/packages/ag-grid-enterprise" +lib-version+))

(task-options!
 pom {:project     'cljsjs/ag-grid-enterprise
      :version     +version+
      :description "The JavaScript Datagrid for Enterprise"
      :url         "http://ag-grid-enterprise.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(def unpkg-url (str "https://unpkg.com/ag-grid-enterprise@" +lib-version+))

(deftask download-lib []
  (download :url (str unpkg-url "/dist/ag-grid-enterprise.js")))

(deftask package []
  (comp
   (download-lib)
   (sift :move {#"ag-grid-enterprise.js" "cljsjs/ag-grid-enterprise/development/ag-grid-enterprise.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/ag-grid-enterprise/development/ag-grid-enterprise.inc.js"
           :out "cljsjs/ag-grid-enterprise/production/ag-grid-enterprise.min.inc.js")
   (deps-cljs :name "cljsjs.ag-grid-enterprise"
              :requires ["cljsjs.ag-grid-community"])
   (pom)
   (jar)
   (validate-checksums)))
