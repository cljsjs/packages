(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/datatables "1.10.16-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "1.10.16")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables-bs
       :version +version+
       :description "DataTables bootstrap plugin"
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/%s/js/dataTables.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables-bs/development/datatables.bootstrap.inc.js")
    (download :url (format "https://cdn.datatables.net/%s/css/dataTables.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables-bs/development/datatables.bootstrap.css")
    (download :url (format "https://cdn.datatables.net/%s/js/dataTables.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables-bs/production/datatables.bootstrap.min.inc.js")
    (download :url (format "https://cdn.datatables.net/%s/css/dataTables.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables-bs/production/datatables.bootstrap.min.css")

	(deps-cljs :name "cljsjs.datatables-bs"
               :requires ["cljsjs.datatables"])
	(pom)
    (jar)
    (validate-checksums)))
