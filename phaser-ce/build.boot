(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.8.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/phaser-ce
       :version     +version+
       :description "Phaser CE is a fast, free, and fun open source framework for Canvas and WebGL powered browser games."
       :url         "http://phaser.io"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/photonstorm/phaser-ce"}})

(deftask package []
  (comp
   (download :url (format "https://cdn.jsdelivr.net/npm/phaser-ce@%s/build/phaser.js" +lib-version+)
             :checksum "807080f307b1d4832cb734dfb13f1422")
   (download :url (format "https://cdn.jsdelivr.net/npm/phaser-ce@%s/build/phaser.map" +lib-version+)
             :checksum "e206b6df8ed9024f45f9ebe6346c3e0a")
   (download :url (format "https://cdn.jsdelivr.net/npm/phaser-ce@%s/build/phaser.min.js" +lib-version+)
             :checksum "b072322e50a661816b8b66feacc63667")
   (sift :move {#"^phaser\.js$"
                "cljsjs/phaser-ce/development/phaser.inc.js"
                #"^phaser\.map$"
                "cljsjs/phaser-ce/development/phaser.map"
                #"^phaser\.min\.js$"
                "cljsjs/phaser-ce/production/phaser.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.phaser-ce")
   (pom)
   (jar)))
