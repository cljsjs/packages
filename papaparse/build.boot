(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.1")
(def +version+ (str +lib-version+ "-1"))

(def download-url
  (str "https://github.com/mholt/PapaParse/archive/" +lib-version+ ".tar.gz"))

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
   (sift :move {#"^PapaParse-.*/papaparse.js" "cljsjs/papaparse/development/papaparse.inc.js"
                #"^PapaParse-.*/papaparse.min.js" "cljsjs/papaparse/production/papaparse.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.papaparse")
   (pom)
   (jar)))
