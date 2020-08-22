(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/quaternion
       :version     +version+
       :description "A rotation library using quaternions."
       :url         "https://github.com/infusion/Quaternion.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-quaternion []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-quaternion)
   (sift :move {#".*quaternion.bundle.js" "cljsjs/quaternion/development/quaternion.inc.js"
                #".*quaternion.ext.js" "cljsjs/quaternion/common/quaternion.ext.js"})
   (minify    :in  "cljsjs/quaternion/development/quaternion.inc.js"
              :out "cljsjs/quaternion/production/quaternion.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["quaternion", "cljsjs.quaternion"]
              :requires []
              :global-exports '{quaternion Quaternion
                                cljsjs.quaternion Quaternion})
   (pom)
   (jar)
   (validate-checksums)))
