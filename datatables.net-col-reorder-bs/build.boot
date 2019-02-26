(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "15.2.1-0"]
                  [cljsjs/react-dom "15.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "1.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables.net-col-reorder-bs
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/colreorder/%s/js/dataTables.colReorder.js" +lib-version+)
              :target "cljsjs/datatables.net-col-reorder-bs/development/datatables.net-col-reorder-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/colreorder/%s/js/dataTables.colReorder.min.js" +lib-version+)
              :target "cljsjs/datatables.net-col-reorder/production/datatables.net-col-reorder-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/colreorder/%s/css/colReorder.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-col-reorder/development/datatables.net-col-reorder-bs.css")
    (download :url (format "https://cdn.datatables.net/colreorder/%s/css/colReorder.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-col-reorder/production/datatables.net-col-reorder-bs.min.css")


	(deps-cljs :name "cljsjs.datatables.net-col-reorder-bs"
               :requires ["cljsjs.datatables.net-bs"])
	(pom)
    (jar)
    (validate)))

