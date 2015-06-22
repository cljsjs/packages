(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def jszip-version "2.5.0")
(def jszip-release "0")
(def +version+ (str jszip-version "-" jszip-release))
(bootlaces! +version+)

(task-options!
 pom {:project 'cljsjs/jszip
      :version +version+
      :description "Create, read and edit .zip files"
      :url "http://stuk.github.io/jszip/"
      :scm {:url "https://github.com/Stuk/jszip"}
      :license {"MIT" "http://opensource.org/licenses/MIT"
                "GPLv3" "http://www.gnu.org/licenses/gpl-3.0.en.html"}})

(def no-exports
  "if(typeof exports !== 'undefined')exports=undefined;")

(def github
  "https://raw.githubusercontent.com/")

(deftask package []
  (comp
   (download
    :url (str github "Stuk/jszip/v" jszip-version "/dist/jszip.js")
    :checksum "b2b9eb4084c03189e0c32bac39f9f44b")
   (download
    :url (str github "Stuk/jszip/v" jszip-version "/dist/jszip.min.js")
    :checksum "88731e24340ce38647f6d595f0e464cb")
   (sift :move {#"^jszip.js"
                "cljsjs/jszip/development/jszip.inc.js"
                #"^jszip.min.js"
                "cljsjs/jszip/production/jszip.min.inc.js"})
   (replace-content :in "cljsjs/jszip/development/jszip.inc.js"
                    :match #"^\/\*" :value (str no-exports "\n/*"))
   (replace-content :in "cljsjs/jszip/production/jszip.min.inc.js"
                    :match #"^\/\*" :value (str no-exports "\n/*"))
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jszip")))
