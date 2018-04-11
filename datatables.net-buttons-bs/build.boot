(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/datatables.net-buttons-bs
       :version +version+
       :description "DataTables is a plug-in for the jQuery Javascript library. It is a highly flexible tool, build upon the foundations of progressive enhancement, that adds all of these advanced features to any HTML table."
       :url "https://github.com/Datatables/Datatables"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (comp
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/css/buttons.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs.css")
    (download :url (format "https://cdn.datatables.net/buttons/%s/css/buttons.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs.min.css")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.colVis.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-col-vis.min.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.colVis.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-col-vis.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.html5.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-html5.min.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.html5.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-html5.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.print.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-print.min.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.print.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-print.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.flash.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-flash.min.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.flash.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-flash.inc.js")

	(deps-cljs :foreign-libs [{:file #"datatables\.net-buttons-bs\.inc\.js"
							   :file-min #"datatables\.net-buttons-bs\.min\.inc\.js"
							   :provides ["cljsjs.datatables.net-buttons-bs"]}

							  {:file #"datatables\.net-buttons-col-vis\.inc\.js"
							   :file-min #"datatables\.net-buttons-col-vis\.min\.inc\.js"
							   :requires ["cljsjs.datatables.net-buttons-bs"]
							   :provides ["cljsjs.datatables.net-buttons-bs-col-vis"]}

							  {:file #"datatables\.net-buttons-html5\.inc\.js"
                               :file-min #"datatables\.net-buttons-html5\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-html5"]}

                              {:file #"datatables\.net-buttons-print\.inc\.js"
                               :file-min #"datatables\.net-buttons-print\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-print"]}

                              {:file #"datatables\.net-buttons-flash\.inc\.js"
                               :file-min #"datatables\.net-buttons-flash\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-flash"]}

							   ]
					:externs [#"datatables\.net-buttons-bs\.ext\.js"])
      (pom)
      (jar))
    (validate-checksums)))

