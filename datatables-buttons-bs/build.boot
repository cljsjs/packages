(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.2.1-0"]
                  [cljsjs/react-dom "15.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(def +lib-version+ "1.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables-buttons-bs
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables-buttons-bs/development/datatables-buttons-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/css/buttons.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables/development/datatables-buttons-bs.css")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables-buttons-bs/production/datatables-buttons-bs.min.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/css/buttons.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables-buttons-bs/production/datatables-buttons-bs.min.css")

	(deps-cljs :name "cljsjs.datatables-buttons-bs"
               :requires ["cljsjs.datatables-buttons"])
	(pom)
    (jar)
    (validate-checksums)))

