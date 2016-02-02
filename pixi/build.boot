(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.4.8"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.7")
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
    (download :url (format "https://github.com/GoodBoyDigital/pixi.js/archive/v%s.zip" +lib-version+)
              :checksum "6ba647faaa66d7190ba68486b1f23c77"
              :unzip true)
    (sift :move {#"^pixi\.js-([\d\.]*)/bin/pixi\.js$" "cljsjs/pixi/development/pixi.inc.js"
                 #"^pixi\.js-([\d\.]*)/bin/pixi\.min\.js$" "cljsjs/pixi/production/pixi.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pixi")))
