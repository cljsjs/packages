(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/hash
        :version     +version+
        :description "A few of many hashing algorithm implementations in plain javascript"
        :url         "https://github.com/indutny/hash.js"
        :license     {"MIT" "https://github.com/indutny/hash.js#license"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://wzrd.in/standalone/hash.js@" +lib-version+))
    (sift :move {(re-pattern (str "^hash.js@" +lib-version+)) "cljsjs/hash/development/hash.inc.js"})
    (minify :in "cljsjs/hash/development/hash.inc.js"
            :out "cljsjs/hash/production/hash.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hash")
    (pom)
    (jar)))
