(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/parse
       :version     +version+
       :description "Parse JavaScript SDK"
       :url         "https://parse.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"" ""}})

(deftask package []
  (comp
    (download :url (format "https://www.parsecdn.com/js/parse-%s.js" +lib-version+)
              :checksum "71741b67b627347c10f08e3993ad971b")
    (download :url (format "https://www.parsecdn.com/js/parse-%s.min.js" +lib-version+)
              :checksum "ed555be064f8828e16147fb1b3dd7676")
    (sift :move {#"parse-([\d\.]*).js" "cljsjs/parse/development/parse.inc.js"
                 #"parse-([\d\.]*).min.js" "cljsjs/parse/production/parse.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.parse")
    (pom)
    (jar)))
