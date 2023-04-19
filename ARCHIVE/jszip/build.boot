(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/jszip
      :version +version+
      :description "Create, read and edit .zip files"
      :url "http://stuk.github.io/jszip/"
      :scm {:url "https://github.com/Stuk/jszip"}
      :license {"MIT" "http://opensource.org/licenses/MIT"
                "GPLv3" "http://www.gnu.org/licenses/gpl-3.0.en.html"}})

(def github
  "https://raw.githubusercontent.com/")

(deftask package []
  (comp
   (download
    :url (str github "Stuk/jszip/v" +lib-version+ "/dist/jszip.js")
    :checksum "b88be5728847a5bce595eaa2f5f3ff26")
   (download
    :url (str github "Stuk/jszip/v" +lib-version+ "/dist/jszip.min.js")
    :checksum "62db1c2504bd4d030ffc37880227d5fd")
   (sift :move {#"^jszip.js"
                "cljsjs/jszip/development/jszip.inc.js"
                #"^jszip.min.js"
                "cljsjs/jszip/production/jszip.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jszip")
   (pom)
   (jar)))
