(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0"  :scope "test"]
                 [cljsjs/d3 "4.12.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.3")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/textures
       :version     +version+
       :description "A JavaScript library for adding svg patterns to d3 visualizations"
       :url         "http://riccardoscalco.github.io/textures/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url "https://raw.githubusercontent.com/riccardoscalco/textures/83094475a6cc6f58e6d0755cb0e7720f156ec65a/dist/textures.js"
             :checksum "14ed87ddddfe4f6e56b9f715f8d11ca6")
   (sift :move {#"textures.js" "cljsjs/textures/development/textures.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.textures"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
