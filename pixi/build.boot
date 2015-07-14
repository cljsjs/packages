(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.0.7-0")
(bootlaces! +version+)

(task-options!
 pom {:project 'cljsjs/pixi
      :version +version+
      :description "JavaScript 2D WebGL rendering library with canvas fallback."
      :url "http://www.pixijs.com/"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"MIT License" "https://github.com/GoodBoyDigital/pixi.js/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "https://github.com/GoodBoyDigital/pixi.js/archive/v3.0.7.zip"
             :checksum "6BA647FAAA66D7190BA68486B1F23C77"
             :unzip true)
   (sift :move {#"pixi.js-[\d\.]*/bin/pixi.js" "cljsjs/development/pixi.inc.js"
                #"pixi.js-[\d\.]*/bin/pixi.min.js" "cljsjs/development/pixi.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi")))
