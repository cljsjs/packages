(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.2.1-0"]
                  [cljsjs/react-dom "15.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "1.2.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables-select
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/select/%s/js/dataTables.select.js" +lib-version+)
              :target "cljsjs/datatables/development/datatables-select.inc.js")
    (download :url (format "https://cdn.datatables.net/select/%s/js/dataTables.select.min.js" +lib-version+)
              :target "cljsjs/datatables/production/datatables-select.min.inc.js")
    (download :url (format "https://cdn.datatables.net/select/%s/css/select.dataTables.css" +lib-version+)
              :target "cljsjs/datatables/development/datatables-select.css")
    (download :url (format "https://cdn.datatables.net/select/%s/css/select.dataTables.min.css" +lib-version+)
              :target "cljsjs/datatables/production/datatables-select.min.css")
    (download :url (format "https://cdn.datatables.net/select/%s/css/select.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables/development/datatables-select-bs.css")
    (download :url (format "https://cdn.datatables.net/select/%s/css/select.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables/production/datatables-select-bs.min.css")


	(deps-cljs :name "cljsjs.datatables-select"
               :requires ["cljsjs.datatables"])
	(pom)
    (jar)
    (validate-checksums)))
