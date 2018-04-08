(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.2.1-0"]
                  [cljsjs/react-dom "15.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "2.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables-keytable
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/keytable/%s/js/dataTables.keyTable.js" +lib-version+)
              :target "cljsjs/datatables/development/datatables-keytable.inc.js")
    (download :url (format "https://cdn.datatables.net/keytable/%s/css/keyTable.dataTables.css" +lib-version+)
              :target "cljsjs/datatables/development/datatables-keytable.css")
    (download :url (format "https://cdn.datatables.net/keytable/%s/js/dataTables.keyTable.min.js" +lib-version+)
              :target "cljsjs/datatables/production/datatables-keytable.min.inc.js")
    (download :url (format "https://cdn.datatables.net/keytable/%s/css/keyTable.dataTables.min.css" +lib-version+)
              :target "cljsjs/datatables/production/datatables-keytable.min.css")
    (download :url (format "https://cdn.datatables.net/keytable/%s/css/keyTable.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables/development/datatables-keytable-bs.css")
    (download :url (format "https://cdn.datatables.net/keytable/%s/css/keyTable.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables/production/datatables-keytable-bs.min.css")
	(deps-cljs :name "cljsjs.datatables-keytable"
               :requires ["cljsjs.datatables"])
	(pom)
    (jar)
    (validate-checksums)))
