(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/leaflet "1.7.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/leaflet-draw
        :version     +version+
        :description "Adds support for drawing and editing vectors and markers on Leaflet maps"
        :url         "https://github.com/Leaflet/Leaflet.draw"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url      (format "https://registry.npmjs.org/leaflet-draw/-/leaflet-draw-%s.tgz" +lib-version+)
              :decompress true
              :compression-format "gz"
              :archive-format "tar")
    (sift :move {#"^.*/dist/leaflet.draw-src.js" "cljsjs/leaflet-draw/development/leaflet-draw.inc.js"
                 #"^.*/dist/leaflet.draw.js" "cljsjs/leaflet-draw/production/leaflet-draw.min.inc.js"
                 #"^.*/dist/leaflet.draw.css" "cljsjs/leaflet-draw/common/leaflet-draw.inc.css"
                 #"^.*/dist/images/(.*).png$" "cljsjs/leaflet-draw/common/images/$1.png"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet-draw"
               :requires ["cljsjs.leaflet"])
    (pom)
    (jar)
    (validate)))
