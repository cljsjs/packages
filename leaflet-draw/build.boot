(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/leaflet "0.7.7-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.3")
(def +version+ (str +lib-version+ "-2"))

(task-options!
  pom  {:project     'cljsjs/leaflet-draw
        :version     +version+
        :description "Adds support for drawing and editing vectors and markers on Leaflet maps"
        :url         "https://github.com/Leaflet/Leaflet.draw"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (format "https://github.com/Leaflet/Leaflet.draw/archive/%s.zip" +lib-version+)
              :checksum "BE611BFB85008C3C964ABE46C3C751D2"
              :unzip    true)
    (sift :move {#"^Leaflet.draw-(.*)/dist/leaflet.draw-src.js"    	"cljsjs/development/leaflet-draw.inc.js"
                 #"^Leaflet.draw-(.*)/dist/leaflet.draw.js"        	"cljsjs/production/leaflet-draw.min.inc.js"
                 #"^Leaflet.draw-(.*)/dist/leaflet.draw.css"       	"cljsjs/common/leaflet-draw.inc.css"
                 #"^Leaflet.draw-(.*)/dist/images/spritesheet.png" 	"cljsjs/common/images/spritesheet.png"
                 #"^Leaflet.draw-(.*)/dist/images/spritesheet-2x.png" "cljsjs/common/images/spritesheet-2x.png"
                 }) ;; TODO Provide one-liner for images
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet-draw"
               :requires ["cljsjs.leaflet"])
    (pom)
    (jar)))
