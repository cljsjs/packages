(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/babylon
       :version     +version+
       :description "Microsoft's Babylon.js 3d game engine"
       :url         "http://www.babylonjs.com/"
       :license     {"Apache" "http://www.apache.org/licenses/LICENSE-2.0"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/BabylonJS/Babylon.js/v%s/dist/babylon.js" +lib-version+)
              :target "cljsjs/babylon/production/babylon.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.babylon")
    (pom)
    (jar)
    (validate)))
