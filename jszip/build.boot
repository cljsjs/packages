(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.0")
(def +version+ (str +lib-version+ "-0"))

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
    :url (str github "Stuk/jszip/v" +lib-version+ "/dist/jszip.js")
    :checksum "b2b9eb4084c03189e0c32bac39f9f44b")
   (download
    :url (str github "Stuk/jszip/v" +lib-version+ "/dist/jszip.min.js")
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
   (deps-cljs :name "cljsjs.jszip")
   (pom)
   (jar)))
