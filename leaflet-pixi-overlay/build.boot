(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                 [cljsjs/leaflet "1.5.1-0"]
                 [cljsjs/pixi-legacy "5.1.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.8.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet-pixi-overlay
       :version     +version+
       :description "Bring Pixi.js power to Leaflet maps"
       :url         "https://github.com/manubb/Leaflet.PixiOverlay"
       :scm         {:url "https://github.com/manubb/Leaflet.PixiOverlay"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
   (download :url (format "http://unpkg.com/leaflet-pixi-overlay@%s/L.PixiOverlay.js" +lib-version+)
             :target "cljsjs/leaflet-pixi-overlay/development/leaflet-pixi-overlay.inc.js")
   (download :url (format "http://unpkg.com/leaflet-pixi-overlay@%s/L.PixiOverlay.min.js" +lib-version+)
             :target "cljsjs/leaflet-pixi-overlay/production/leaflet-pixi-overlay.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["cljsjs.leaflet-pixi-overlay"]
              :requires ["cljsjs.leaflet"
                         "cljsjs.pixi-legacy"])
   (pom)
   (jar)
   (validate)))
