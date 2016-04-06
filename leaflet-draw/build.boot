(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.3")
(def +version+ (str +lib-version+ "-1"))

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
    (download :url      (str "https://github.com/Leaflet/Leaflet.draw/archive/master.zip")
              :checksum "C2316EBEDD093B67F5F7083F75097444"
              :unzip    true)
    (sift :move {#"^Leaflet.draw-master/dist/leaflet.draw-src.js"    	"cljsjs/development/leaflet-draw.inc.js"
                 #"^Leaflet.draw-master/dist/leaflet.draw.js"        	"cljsjs/production/leaflet-draw.min.inc.js"
                 #"^Leaflet.draw-master/dist/leaflet.draw.css"       	"cljsjs/common/leaflet-draw.inc.css"
                 #"^Leaflet.draw-master/dist/images/spritesheet.png" 	"cljsjs/common/images/spritesheet.png"
                 #"^Leaflet.draw-master/dist/images/spritesheet-2x.png" "cljsjs/common/images/spritesheet-2x.png"
                 }) ;; TODO Provide one-liner for images
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet-draw")
    (pom)
    (jar)))
