(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.10.16")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/datatables.net
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/datatables.net"}
        :description "DataTables for jQuery"
        :url         "https://datatables.net"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.datatables.net/%s/js/jquery.dataTables.js" +lib-version+)
              :target "cljsjs/datatables.net/development/datatables.net.inc.js")
    (download :url (format "https://cdn.datatables.net/%s/js/jquery.dataTables.min.js" +lib-version+)
              :target "cljsjs/datatables.net/production/datatables.net.min.inc.js")

    (deps-cljs :foreign-libs [{:file #"datatables\.net\.inc\.js"
    						   :file-min #"datatables\.net\.min\.inc\.js"
    						   :requires ["cljsjs.jquery"]
                               :provides ["cljsjs.datatables.net"]}]
               :externs [#"jquery\.dataTables\.ext\.js"])
    (pom)
    (jar)
    (validate)))
