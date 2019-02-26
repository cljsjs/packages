(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/datatables.net-select-bs
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/datatables.net-select-bs"}
        :description "select extension for DataTables library with bootstrap styling"
        :url         "https://datatables.net"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.datatables.net/select/%s/js/dataTables.select.js" +lib-version+)
              :target "cljsjs/datatables.net-select-bs/development/datatables.net-select.inc.js")
    (download :url (format "https://cdn.datatables.net/select/%s/js/dataTables.select.min.js" +lib-version+)
              :target "cljsjs/datatables.net-select-bs/production/datatables.net-select.min.inc.js")

    (download :url (format "https://cdn.datatables.net/select/%s/css/select.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-select-bs/development/datatables.net-select-bs.css")
    (download :url (format "https://cdn.datatables.net/select/%s/css/select.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-select-bs/production/datatables.net-select-bs.min.css")


    (deps-cljs :foreign-libs [{:file #"datatables\.net-select\.inc\.js"
    						   :file-min #"datatables\.net-select\.min\.inc\.js"
    						   :requires ["cljsjs.datatables.net-bs"]
                               :provides ["cljsjs.datatables.net-select-bs"]}]
               :externs [#"datatables\.net-select-bs\.ext\.js"])
	(pom)
    (jar)
    (validate)))
