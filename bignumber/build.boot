(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/bignumber
       :version     +version+
       :description "A JavaScript library for arbitrary-precision decimal and non-decimal arithmetic."
       :url         "http://mikemcl.github.io/bignumber.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-bignumber []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-bignumber)
   (sift :move {#".*bignumber.bundle.js" "cljsjs/bignumber/development/bignumber.inc.js"
                #".*bignumber.ext.js" "cljsjs/bignumber/common/bignumber.ext.js"})
   (minify :in  "cljsjs/bignumber/development/bignumber.inc.js"
           :out "cljsjs/bignumber/production/bignumber.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["bignumber.js", "cljsjs.bignumber"]
              :requires []
              :global-exports '{bignumber.js BigNumber
                                cljsjs.bignumber BigNumber})
   (pom)
   (jar)
   (validate-checksums)))
