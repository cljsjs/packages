(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.11")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/complex
       :version     +version+
       :description "A well tested JavaScript library to work with complex number arithmetic in JavaScript."
       :url         "https://github.com/infusion/Complex.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-complex []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-complex)
   (sift :move {#".*complex.bundle.js" "cljsjs/complex/development/complex.inc.js"
                #".*complex.ext.js" "cljsjs/complex/common/complex.ext.js"})
   (minify    :in  "cljsjs/complex/development/complex.inc.js"
              :out "cljsjs/complex/production/complex.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["complex.js", "cljsjs.complex"]
              :requires []
              :global-exports '{complex.js Complex
                                cljsjs.complex Complex})
   (pom)
   (jar)
   (validate-checksums)))
