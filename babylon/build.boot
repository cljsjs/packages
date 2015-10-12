(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.2.0-0")

(task-options!
 pom  {:project     'cljsjs/babylon
       :version     +version+
       :description "Microsoft's Babylon.js 3d game engine"
       :url         "http://www.babylonjs.com/"
       :license     {"Apache" "http://www.apache.org/licenses/LICENSE-2.0"}
       :scm         {:url "https://github.com/cljsjs/packages"}})
			 
(deftask package []
  (comp
    (download :url "http://cdn.babylonjs.com/2-2/babylon.js")
    (sift :move {#"babylon.js" "cljsjs/babylon/development/babylon.inc.js"})
    (download :url "http://cdn.babylonjs.com/2-2/babylon.js")
    (sift :move {#"babylon.js" "cljsjs/babylon/production/babylon.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.babylon")))