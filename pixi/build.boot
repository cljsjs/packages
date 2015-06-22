(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.8"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.0.6-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/pixi
       :version     +version+
       :description "2D webGL renderer with canvas fallback"
       :url         "http://www.pixijs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/GoodBoyDigital/pixi.js/archive/v3.0.6.zip"
              :checksum "dc195e04be140dc88a3cf05bde66a78e"
              :unzip true)
    (sift :move {#"^pixi\.js-([\d\.]*)/bin/pixi\.js$" "cljsjs/pixi/development/pixi.inc.js"
                 #"^pixi\.js-([\d\.]*)/bin/pixi\.min\.js$" "cljsjs/pixi/production/pixi.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pixi")))
