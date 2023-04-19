(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "16.3.2-0"]
                  [cljsjs/react-dom "16.3.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.8.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/react-table
        :version     +version+
        :description "react-table is a lightweight, fast and extendable datagrid built for React"
        :url         "https://github.com/react-tools/react-table"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp

    (download :url (format "https://unpkg.com/react-table@%s/react-table.js" +lib-version+)
              :target "cljsjs/react-table/development/react-table.inc.js") 
    (download :url (format "https://unpkg.com/react-table@%s/react-table.css" +lib-version+)
              :target "cljsjs/react-table/development/react-table.inc.css")           

    (download :url (format "https://unpkg.com/react-table@%s/react-table.min.js" +lib-version+)
              :target "cljsjs/react-table/production/react-table.min.inc.js") 
    (download :url (format "https://unpkg.com/react-table@%s/react-table.css" +lib-version+)
              :target "cljsjs/react-table/production/react-table.inc.css")   

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-table"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)
    (jar)
    (validate)))
