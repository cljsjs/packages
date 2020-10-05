(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.12")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/bigfraction
       :version     +version+
       :description "BigFraction is an arbitrary precision version of Fraction,
       a rational number library written in JavaScript."
       :url         "https://github.com/infusion/Fraction.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-fraction []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-fraction)
   (sift :move {#".*bigfraction.bundle.js" "cljsjs/fraction/development/bigfraction.inc.js"
                #".*bigfraction.ext.js" "cljsjs/fraction/common/bigfraction.ext.js"})
   (minify    :in  "cljsjs/fraction/development/bigfraction.inc.js"
              :out "cljsjs/fraction/production/bigfraction.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["fraction.js/bigfraction.js", "cljsjs.bigfraction"]
              :requires []
              :global-exports '{fraction.js/bigfraction.js BigFraction
                                cljsjs.bigfraction BigFraction})
   (pom)
   (jar)
   (validate-checksums)))
