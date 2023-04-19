(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [degree9/boot-npm "1.4.0" :scope "test"]
                  [cljsjs/pixi "4.4.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(require '[degree9.boot-npm :as npm])

(def +lib-version+ "1.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pixi-sound
       :version     +version+
       :description "WebAudio API playback without any Flash shims or HTML Audio fallback."
       :url         "https://github.com/pixijs/pixi-sound"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

;; may use later if pixi-sound provied versioned download url
(deftask url-download []
  (download :url "https://pixijs.github.io/pixi-sound/dist/pixi-sound.js"))

(deftask package []
  (comp
   (npm/npm :install {:pixi-sound +lib-version+})
   (sift :move {#"node_modules/pixi-sound/dist/pixi-sound\.js$" "cljsjs/pixi-sound/development/pixi-sound.inc.js"
                #"node_modules/pixi-sound/dist/pixi-sound\.min\.js$" "cljsjs/pixi-sound/production/pixi-sound.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi-sound"
              :requires ["cljsjs.pixi"])
   (pom)
   (jar)))
