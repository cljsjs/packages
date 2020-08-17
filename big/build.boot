(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.2.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/big
       :version     +version+
       :description "A JavaScript library for arbitrary-precision decimal and non-decimal arithmetic."
       :url         "http://mikemcl.github.io/big.js/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-big []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-big)
   (sift :move {#".*big.bundle.js" "cljsjs/big/development/big.inc.js"
                #".*big.ext.js" "cljsjs/big/common/big.ext.js"})
   (minify :in  "cljsjs/big/development/big.inc.js"
           :out "cljsjs/big/production/big.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["big.js", "cljsjs.big"]
              :requires []
              :global-exports '{big.js Big
                                cljsjs.big Big})
   (pom)
   (jar)))
