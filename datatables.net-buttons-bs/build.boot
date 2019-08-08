(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/datatables.net-buttons-bs
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/datatables.net-buttons-bs"}
        :description "Buttons extension for DataTables library with bootstrap styling"
        :url         "https://datatables.net"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/dataTables.buttons.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/dataTables.buttons.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.bootstrap.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.bootstrap.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.colVis.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs-col-vis.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.colVis.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs-col-vis.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.flash.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs-flash.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.flash.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs-flash.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.print.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs-print.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.print.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs-print.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.html5.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs-html5.inc.js")
    (download :url (format "https://cdn.datatables.net/buttons/%s/js/buttons.html5.min.js" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs-html5.min.inc.js")

    (download :url (format "https://cdn.datatables.net/buttons/%s/css/buttons.bootstrap.css" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/development/datatables.net-buttons-bs.css")
    (download :url (format "https://cdn.datatables.net/buttons/%s/css/buttons.bootstrap.min.css" +lib-version+)
              :target "cljsjs/datatables.net-buttons-bs/production/datatables.net-buttons-bs.min.css")


    (deps-cljs :foreign-libs [{:file #"datatables\.net-buttons\.inc\.js"
    						   :file-min #"datatables\.net-buttons\.min\.inc\.js"
    						   :requires ["cljsjs.datatables.net"]
                               :provides ["cljsjs.datatables.net-buttons"]}
                              {:file #"datatables\.net-buttons-bs\.inc\.js"
                               :file-min #"datatables\.net-buttons-bs\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons"]
                               :provides ["cljsjs.datatables.net-buttons-bs"]}
                              {:file #"datatables\.net-buttons-bs-col-vis\.inc\.js"
                               :file-min #"datatables\.net-buttons-bs-col-vis\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-col-vis"]}
                              {:file #"datatables\.net-buttons-bs-flash\.inc\.js"
                               :file-min #"datatables\.net-buttons-bs-flash\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-flash"]}
                              {:file #"datatables\.net-buttons-bs-print\.inc\.js"
                               :file-min #"datatables\.net-buttons-bs-print\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-print"]}
                              {:file #"datatables\.net-buttons-bs-html5\.inc\.js"
                               :file-min #"datatables\.net-buttons-bs-html5\.min\.inc\.js"
                               :requires ["cljsjs.datatables.net-buttons-bs"]
                               :provides ["cljsjs.datatables.net-buttons-bs-html5"]}
                                ]
               :externs [#"datatables\.net-buttons-bs\.ext\.js"])
	(pom)
    (jar)
    (validate)))
