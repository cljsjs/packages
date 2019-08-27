(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

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

(deftask build-bn []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
    (build-bn)
    (sift :move {#".*bn.bundle.js" "cljsjs/bn/development/bn.inc.js"
                 #".*bn.ext.js" "cljsjs/bn/common/bn.ext.js"})
    (minify :in "cljsjs/bn/development/bn.inc.js"
            :out "cljsjs/bn/production/bn.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bn")
    (pom)
    (jar)))
