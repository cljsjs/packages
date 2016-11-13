(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pixi
       :version     +version+
       :description "2D webGL renderer with canvas fallback"
       :url         "http://www.pixijs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "http://pixijs.download/release/pixi.js"
              :checksum "697f41d0b43b77a7cddfbcf3aefefa50")
    (download :url "http://pixijs.download/release/pixi.min.js"
              :checksum "7ad2d0cb8e15ea532bbd3dbca77c55fe")
    (sift :move {#"^pixi.js$" "cljsjs/pixi/development/pixi.inc.js"
                 #"^pixi.min.js$" "cljsjs/pixi/production/pixi.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pixi")
    (pom)
    (jar)))
