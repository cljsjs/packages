(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces          "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs        "0.4.6"  :scope "test"]
                  [cljsjs/react              "0.13.0-0"]
                  [cljsjs/object-assign-shim "0.1.0-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.2-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/fixed-data-table
       :version     +version+
       :description "A React table component designed to allow presenting thousands of rows of data."
       :url         "https://github.com/facebook/fixed-data-table"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-fixed-data-table []
  (download :url      "https://github.com/facebook/fixed-data-table/archive/v0.1.2.zip"
            :checksum "36d76016a61911b838c74470c84e6d27"
            :unzip    true))

(deftask package []
  (comp
    (download-fixed-data-table)
    (sift :move {#"^fixed-data-table-.*/dist/fixed-data-table.js"
                 "cljsjs/development/fixed-data-table.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.css"
                 "cljsjs/development/fixed-data-table.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.js"
                 "cljsjs/production/fixed-data-table.min.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.css"
                 "cljsjs/production/fixed-data-table.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fixed-data-table"
               :requires ["cljsjs.react" "cljsjs.object-assign-shim"])))
