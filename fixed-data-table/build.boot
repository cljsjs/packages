(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]
                  [cljsjs/react       "0.12.2-7"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.1-0-og1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/fixed-data-table
       :version     +version+
       :description "FixedDataTable is a React component for building and presenting data in a flexible, powerful way."
       :url         "https://github.com/facebook/fixed-data-table"
       :scm         {:url "https://github.com/cljsjs/packages"}
	   ; License file says "BSD License"
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-fixed-data-table []
  (download ;:url      "https://github.com/facebook/fixed-data-table/archive/v0.1.1.zip"
            :url      "v0.1.1.zip"
            ;:checksum "dbbcd495afd6627ccdad70be28555fad"
            :unzip    true))

(deftask package []
  (comp
    (download-fixed-data-table)
    (sift :move {#"^fixed-data-table-.*/dist/fixed-data-table.js"      "cljsjs/development/fixed-data-table.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.js"  "cljsjs/production/fixed-data-table.min.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.css"     "cljsjs/common/css/fixed-data-table.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.css" "cljsjs/common/css/fixed-data-table.inc.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fixed-data-table"
               :requires ["cljsjs.react"])))
