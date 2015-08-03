(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.4.2-0")
(bootlaces! +version+)

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/phaser
       :version     +version+
       :description "Phaser is a fast, free, and fun open source framework for Canvas and WebGL powered browser games."
       :url         "http://phaser.io"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/photonstorm/phaser"}})

(deftask package []
  (comp
   (download :url "http://cdn.jsdelivr.net/phaser/2.4.2/phaser.zip"
             :checksum "f74d415e21fd6b26819c7f2fe2de9a8d"
             :unzip true)
   (sift :move {#"^phaser\.js$"
                "cljsjs/phaser/development/phaser.inc.js"
                #"^phaser\.map$"
                "cljsjs/phaser/development/phaser.map"
                #"^phaser\.min\.js$"
                "cljsjs/phaser/production/phaser.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.phaser")))
