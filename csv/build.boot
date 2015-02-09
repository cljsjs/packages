(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.1.1-0")

(task-options!
  pom  {:project     'cljsjs/csv
        :version     +version+
        :description "A Comma-Separated Values parser for JavaScript. Standards-based, stand alone, and no regular expressions."
        :url         "http://gkindel.github.io/CSV-JS/csv.html"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "https://github.com/gkindel/CSV-JS/archive/v1.1.1.zip"
              :checksum "caac853bc54bd82121ebc0bc06b13514"
              :unzip true)
    (sift :move {#"^CSV-JS-.*/csv.js" "cljsjs/development/csv.inc.js"})
    (minify :in "cljsjs/development/csv.inc.js" :out "cljsjs/production/csv.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.csv")))
