(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "1.10.16")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables.net-bs
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.datatables.net/%s/js/dataTables.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables.net-bs/development/datatables.net-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/%s/js/dataTables.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables.net-bs/production/datatables.net-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/%s/css/dataTables.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-bs/development/datatables.net-bs.css")
    (download :url (format "https://cdn.datatables.net/%s/css/dataTables.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-bs/production/datatables.net-bs.min.css")

    (deps-cljs :foreign-libs [{:file #"datatables\.net-bs\.inc\.js"
    						   :file-min #"datatables\.net-bs\.min\.inc\.js"
    						   :requires ["cljsjs.datatables.net"]
                               :provides ["cljsjs.datatables.net-bs"]}]
               :externs [#"datatables\.net-bs\.ext\.js"])
	(pom)
    (jar)
    (validate)))
