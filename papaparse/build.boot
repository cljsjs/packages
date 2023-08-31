(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/papaparse
       :version     +version+
       :description "Parse CSV with JavaScript"
       :url         "https://www.papaparse.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (format "https://unpkg.com/papaparse@v%s/papaparse.min.js" +lib-version+)
    :target "cljsjs/papaparse/production/papaparse.min.inc.js")
   (download
    :url (format "https://unpkg.com/papaparse@v%s/papaparse.js" +lib-version+)
    :target "cljsjs/papaparse/development/papaparse.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.papaparse")
   (pom)
   (jar)
   (validate-checksums)))
