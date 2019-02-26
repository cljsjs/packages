(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/datatables.net-keytable-bs
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/datatables.net-keytable-bs"}
        :description "Keytable extension for DataTables library with bootstrap styling"
        :url         "https://datatables.net"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.datatables.net/keytable/%s/js/dataTables.keyTable.js" +lib-version+)
              :target "cljsjs/datatables.net-keytable-bs/development/datatables.net-keytable.inc.js")
    (download :url (format "https://cdn.datatables.net/keytable/%s/js/dataTables.keyTable.min.js" +lib-version+)
              :target "cljsjs/datatables.net-keytable-bs/production/datatables.net-keytable.min.inc.js")

    (download :url (format "https://cdn.datatables.net/keytable/%s/css/keyTable.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-keytable-bs/development/datatables.net-keytable-bs.css")
    (download :url (format "https://cdn.datatables.net/keytable/%s/css/keyTable.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-keytable-bs/production/datatables.net-keytable-bs.min.css")


    (deps-cljs :foreign-libs [{:file #"datatables\.net-keytable\.inc\.js"
    						   :file-min #"datatables\.net-keytable\.min\.inc\.js"
    						   :requires ["cljsjs.datatables.net-bs"]
                               :provides ["cljsjs.datatables.net-keytable-bs"]}]
               :externs [#"datatables\.net-keytable-bs\.ext\.js"])
	(pom)
    (jar)
    (validate)))
