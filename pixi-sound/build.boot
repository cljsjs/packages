(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/pixi "4.4.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pixi-sound
       :version     +version+
       :description "WebAudio API playback without any Flash shims or HTML Audio fallback."
       :url         "https://github.com/pixijs/pixi-sound"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url  "https://pixijs.github.io/pixi-sound/dist/pixi-sound.js")
   (download :url  "https://pixijs.github.io/pixi-sound/dist/pixi-sound.min.js")
   (sift :move {#"pixi-sound\.js$" "cljsjs/pixi-sound/development/pixi-sound.inc.js"
                #"pixi-sound\.min\.js$" "cljsjs/pixi-sound/production/pixi-sound.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi-sound"
              :requires ["cljsjs.pixi"])
   (pom)
   (jar)))
