(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/fraction
       :version     +version+
       :description "Fraction is a rational number library written in JavaScript."
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
   (sift :move {#".*fraction.bundle.js" "cljsjs/fraction/development/fraction.inc.js"
                #".*fraction.ext.js" "cljsjs/fraction/common/fraction.ext.js"})
   (minify    :in  "cljsjs/fraction/development/fraction.inc.js"
              :out "cljsjs/fraction/production/fraction.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["fraction.js", "cljsjs.fraction"]
              :requires []
              :global-exports '{fraction.js Fraction
                                cljsjs.fraction Fraction})
   (pom)
   (jar)
   (validate-checksums)))
