(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/datatables.net-responsive-bs
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/datatables.net-responsive-bs"}
        :description "Responsive extension for DataTables library with bootstrap styling"
        :url         "https://datatables.net"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/responsive.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/development/datatables.net-responsive-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/responsive/%s/js/responsive.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/production/datatables.net-responsive-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/responsive/%s/css/responsive.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/development/datatables.net-responsive-bs.css")
    (download :url (format "https://cdn.datatables.net/responsive/%s/css/responsive.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-responsive-bs/production/datatables.net-responsive-bs.min.css")

    (deps-cljs :foreign-libs [{:file #"datatables\.net-responsive-bs\.inc\.js"
    						   :file-min #"datatables\.net-responsive-bs\.min\.inc\.js"
    						   :requires ["cljsjs.datatables.net-bs" "cljsjs.datatables.net-responsive"]
                               :provides ["cljsjs.datatables.net-responsive-bs"]}]
               :externs [#"datatables\.net-responsive-bs\.ext\.js"])
	(pom)
    (jar)
    (validate)))
