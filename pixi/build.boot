(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.6.0")
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
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/pixi.js/" +lib-version+ "/pixi.min.js")
              :checksum "732A2D55D7FA04FB81C0584B329AAEC0")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/pixi.js/" +lib-version+ "/pixi.js")
              :checksum "4B179C8BEC4AA50EF20D81D1D14BC664")
    (sift :move {#"pixi\.js$" "cljsjs/pixi/development/pixi.inc.js"
                 #"pixi\.min\.js$" "cljsjs/pixi/development/pixi.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pixi")
    (pom)
    (jar)))
