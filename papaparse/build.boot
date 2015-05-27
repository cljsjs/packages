(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.8" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def papaparse-version "4.1.1")
(def +version+ (str papaparse-version "-0"))

(def download-url
  (str "https://github.com/mholt/PapaParse/archive/" papaparse-version ".tar.gz"))

(task-options!
  pom  {:project     'cljsjs/papaparse
        :version     +version+
        :description "Fast and powerful CSV (delimited text) parser that gracefully handles large files and malformed input"
        :url         "http://PapaParse.com"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url download-url
             :checksum "4cb16d0638df3f1934ca0553d81ae33b"
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"^PapaParse-.*/papaparse.js" "cljsjs/development/papaparse.inc.js"
                #"^PapaParse-.*/papaparse.min.js" "cljsjs/development/papaparse.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.papaparse")))
