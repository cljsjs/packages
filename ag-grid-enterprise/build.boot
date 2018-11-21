(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/ag-grid "15.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[clojure.java.io :as io])

(def +lib-version+ "17.0.0")
(def +lib-checksum+ "E5E174584DF1655F2E8BDEFCEAB0BA2A")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "ag-grid-enterprise-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/ag-grid-enterprise
       :version     +version+
       :description "The JavaScript Datagrid for Enterprise"
       :url         "http://ag-grid-enterprise.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
         (download :url (format "https://github.com/ceolter/ag-grid-enterprise/archive/%s.zip" +lib-version+)
                   :checksum +lib-checksum+
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
                      :requires ["cljsjs.ag-grid"])
           (pom)
           (jar)))
