(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/odex
       :version     +version+
       :description "Numerically solves of non-stiff systems of ordinary differential equations in JavaScript."
       :url         "https://github.com/littleredcomputer/odex-js"
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-odex []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-odex)
   (sift :move {#".*odex.bundle.js" "cljsjs/odex/development/odex.inc.js"
                #".*odex.ext.js" "cljsjs/odex/common/odex.ext.js"})
   (minify :in "cljsjs/odex/development/odex.inc.js"
           :out "cljsjs/odex/production/odex.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.odex")
   (pom)
   (jar)
   (validate-checksums)))
