(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces          "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs        "0.5.0"  :scope "test"]
                  [cljsjs/react              "0.13.3-0"]
                  [cljsjs/object-assign-shim "0.1.0-1"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.4.1-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/fixed-data-table
       :version     +version+
       :description "A React table component designed to allow presenting thousands of rows of data."
       :url         "https://github.com/facebook/fixed-data-table"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-fixed-data-table []
  (download :url      "https://github.com/facebook/fixed-data-table/archive/v0.4.6.zip"
            :checksum "4C8ED4C7140A7AB64291997515EC1F02"
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
