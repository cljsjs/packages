(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/datatables.net-responsive
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/datatables.net-responsive"}
        :description "Responsive extension for DataTables library"
        :url         "https://datatables.net"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/dataTables.responsive.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive/development/datatables.net-responsive.inc.js")
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/dataTables.responsive.min.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive/production/datatables.net-responsive.min.inc.js")

    (deps-cljs :foreign-libs [{:file #"datatables\.net-responsive\.inc\.js"
    						   :file-min #"datatables\.net-responsive\.min\.inc\.js"
    						   :requires ["cljsjs.datatables.net"]
                               :provides ["cljsjs.datatables.net-responsive"]}]
               :externs [#"datatables\.net-responsive\.ext\.js"])
	(pom)
    (jar)
    (validate-checksums)))
