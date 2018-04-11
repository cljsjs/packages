(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.2.1-0"]
                  [cljsjs/react-dom "15.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables.net-responsive-bs
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/dataTables.responsive.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/development/datatables.net-responsive.inc.js")
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/dataTables.responsive.min.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/production/datatables.net-responsive.min.inc.js")

    (download :url (format "https://cdn.datatables.net/responsive/%s/js/responsive.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/development/datatables.net-responsive-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/responsive.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/production/datatables.net-responsive-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/responsive/%s/css/responsive.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/development/datatables.net-responsive-bs.css")
    (download :url (format "https://cdn.datatables.net/responsive/%s/css/responsive.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/production/datatables.net-responsive-bs.min.css")

	(deps-cljs :name "cljsjs.datatables.net-responsive-bs"
               :requires ["cljsjs.datatables.net-bs"])
	(pom)
    (jar)
    (validate-checksums)))
