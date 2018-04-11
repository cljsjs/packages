(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.2.1-0"]
                  [cljsjs/react-dom "15.2.1-0"]])

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
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/%s/js/jquery.dataTables.js" +lib-version+)
              :target "cljsjs/datatables.net-bs/development/datatables.net.inc.js")
    (download :url (format "https://cdn.datatables.net/%s/js/jquery.dataTables.min.js" +lib-version+)
              :target "cljsjs/datatables.net-bs/production/datatables.net.min.inc.js")

    (download :url (format "https://cdn.datatables.net/%s/js/dataTables.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables.net-bs/development/datatables.net-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/%s/js/dataTables.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables.net-bs/production/datatables.net-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/%s/css/dataTables.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-bs/development/datatables.net-bs.css")
    (download :url (format "https://cdn.datatables.net/%s/css/dataTables.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-bs/production/datatables.net-bs.min.css")

	(deps-cljs :name "cljsjs.datatables.net-bs"
               :requires ["cljsjs.jquery"])
	(pom)
    (jar)
    (validate-checksums)))
