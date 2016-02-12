(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.2")
(def +version+ (str +lib-version+ "-0"))

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
   (download :url (format "http://cdn.jsdelivr.net/phaser/%s/phaser.zip" +lib-version+)
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
