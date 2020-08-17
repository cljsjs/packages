(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "10.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/decimal
       :version     +version+
       :description "An arbitrary-precision Decimal type for JavaScript."
       :url         "http://mikemcl.github.io/decimal.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-decimal []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-decimal)
   (sift :move {#".*decimal.bundle.js" "cljsjs/decimal/development/decimal.inc.js"
                #".*decimal.ext.js" "cljsjs/decimal/common/decimal.ext.js"})
   (minify :in  "cljsjs/decimal/development/decimal.inc.js"
           :out "cljsjs/decimal/production/decimal.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["decimal.js", "cljsjs.decimal"]
              :requires []
              :global-exports '{decimal.js Decimal
                                cljsjs.decimal Decimal})
   (pom)
   (jar)
   (validate-checksums)))
