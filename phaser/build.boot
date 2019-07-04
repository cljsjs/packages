(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.18.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/phaser
       :version     +version+
       :description "Phaser is a fast, free, and fun open source framework for Canvas and WebGL powered browser games."
       :url         "http://phaser.io"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/photonstorm/phaser"}})

(deftask package []
  (comp
   (download :url (format "https://cdn.jsdelivr.net/npm/phaser@%s/dist/phaser.js" +lib-version+)
             :target "cljsjs/phaser/development/phaser.inc.js")
   (download :url (format "https://cdn.jsdelivr.net/npm/phaser@%s/dist/phaser.min.js" +lib-version+)
             :target "cljsjs/phaser/production/phaser.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.phaser")
   (pom)
   (jar)
   (validate-checksums)))
