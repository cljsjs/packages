(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "2.2.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/tableauwdc
       :version     +version+
       :description (str "Create a Web Data Connector (WDC) when you want to connect "
                         "to a web data source from Tableau. A WDC is an HTML page with "
                         "JavaScript code that connects to web data (for example, by means "
                         "of a REST API), converts the data to a JSON format, and passes "
                         "the data to Tableau.")
       :url         "https://tableau.github.io/webdataconnector/docs/wdc_library_versions"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://connectors.tableau.com/libs/tableauwdc-%s.js" +lib-version+)
             :checksum "4b5bb09365d8827cdb0aec6e420a0ba6") ;; MD5
   (download :url (format "https://connectors.tableau.com/libs/tableauwdc-%s.min.js" +lib-version+)
             :checksum "1f21bedfa7f6241897f6a01acf9ff4f1") ;; MD5
   (sift :move {(re-pattern (format "tableauwdc-%s.js" +lib-version+)) "cljsjs/tableauwdc/development/tableauwdc.inc.js"
                (re-pattern (format "tableauwdc-%s.min.js" +lib-version+)) "cljsjs/tableauwdc/production/tableauwdc.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.tableauwdc")
   (pom)
   (jar)))
