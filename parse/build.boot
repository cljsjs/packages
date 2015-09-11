(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.6.0-0")

(task-options!
 pom  {:project     'cljsjs/parse
       :version     +version+
       :description "Parse JavaScript SDK"
       :url         "https://parse.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"" ""}})

(deftask package []
  (comp
    (download :url "https://www.parsecdn.com/js/parse-1.6.0.js"
              :checksum "71741b67b627347c10f08e3993ad971b")
    (download :url "https://www.parsecdn.com/js/parse-1.6.0.min.js"
              :checksum "ed555be064f8828e16147fb1b3dd7676")
    (sift :move {#"parse-([\d\.]*).js" "cljsjs/parse/development/parse.inc.js"
                 #"parse-([\d\.]*).min.js" "cljsjs/parse/production/parse.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.parse")))
