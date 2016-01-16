(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs        "0.5.0"  :scope "test"]
                  [cljsjs/react              "0.13.3-0"]
                  [cljsjs/object-assign-shim "0.1.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/fixed-data-table
       :version     +version+
       :description "A React table component designed to allow presenting thousands of rows of data."
       :url         "https://github.com/facebook/fixed-data-table"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-fixed-data-table []
  (download :url      (format "https://github.com/facebook/fixed-data-table/archive/v%s.zip" +lib-version+)
            :checksum "0903f335f5285f2371f43e29161ecfd9"
            :unzip    true))

(deftask package []
  (comp
    (download-fixed-data-table)
    (sift :move {#"^fixed-data-table-.*/dist/fixed-data-table.js"
                 "cljsjs/development/fixed-data-table.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.css"
                 "cljsjs/development/fixed-data-table.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-base.css"
                 "cljsjs/development/fixed-data-table-base.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-style.css"
                 "cljsjs/development/fixed-data-table-style.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.js"
                 "cljsjs/production/fixed-data-table.min.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.css"
                 "cljsjs/production/fixed-data-table.min.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-base.min.css"
                 "cljsjs/production/fixed-data-table-base.min.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-style.min.css"
                 "cljsjs/production/fixed-data-table-style.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fixed-data-table"
               :requires ["cljsjs.react" "cljsjs.object-assign-shim"])))
