(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

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

(deftask download-datatables-net []
  (download :url      (format "https://github.com/DataTables/Dist-DataTables/archive/%s.zip" +lib-version+)
            :unzip    true))

(deftask package []
  (comp
    (download-datatables-net)
    (sift :move {#"^Dist-DataTables-[^\/]*/js/jquery.dataTables\.min\.js" "cljsjs/production/jquery.dataTables.min.inc.js"
                    #"^Dist-DataTables-[^\/]*/js/jquery.dataTables\.js" "cljsjs/development/jquery.dataTables.inc.js"})
    (deps-cljs :name "cljsjs.datatables.net"
               :requires ["cljsjs.jquery"])
    (pom)
    (jar)
    (validate-checksums)))
