(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1" :scope "test"]
                  [cljsjs/leaflet "1.2.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.12")
(def +version+ (str +lib-version+ "-0"))

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
    (download :url      (format "https://registry.npmjs.org/leaflet-draw/-/leaflet-draw-%s.tgz" +lib-version+)
              :checksum "C243F3F76278A151D5660858DAE6E140"
              :decompress true
              :compression-format "gz"
              :archive-format "tar"
              :name "package")
    (sift :move {#"^.*/dist/leaflet.draw-src.js"    	"cljsjs/development/leaflet-draw.inc.js"
                 #"^.*/dist/leaflet.draw.js"        	"cljsjs/production/leaflet-draw.min.inc.js"
                 #"^.*/dist/leaflet.draw.css"       	"cljsjs/common/leaflet-draw.inc.css"
                 #"^.*/dist/images/(.*).png$" 	"cljsjs/common/images/$1.png"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet-draw"
               :requires ["cljsjs.leaflet"])
    (pom)
    (jar)))
