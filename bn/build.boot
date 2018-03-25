(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.11.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/bn
        :version     +version+
        :description "BigNum in pure javascript"
        :url         "https://github.com/indutny/bn.js"
        :license     {"MIT" "https://github.com/indutny/bn.js#license"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://wzrd.in/standalone/bn.js@" +lib-version+))
    (sift :move {(re-pattern (str "^bn.js@" +lib-version+)) "cljsjs/bn/development/bn.inc.js"})
    (minify :in "cljsjs/bn/development/bn.inc.js"
            :out "cljsjs/bn/production/bn.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bn")
    (pom)
    (jar)))
