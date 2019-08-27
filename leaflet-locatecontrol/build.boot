(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/leaflet "0.7.7-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.43.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/leaflet-locatecontrol
        :version     +version+
        :description "A useful control to geolocate the user with many options"
        :url         "https://github.com/domoritz/leaflet-locatecontrol"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (str "https://github.com/domoritz/leaflet-locatecontrol/archive/v" +lib-version+ ".zip")
              :checksum "D95D86C46B22BCD5F1B9C88DC4942EDA"
              :unzip    true)
    (sift :move {#"^leaflet-locatecontrol-(.*)/src/L.Control.Locate.js"           "cljsjs/development/leaflet-locate.inc.js"
                 #"^leaflet-locatecontrol-(.*)/dist/L.Control.Locate.min.js"      "cljsjs/production/leaflet-locate.min.inc.js"
                 #"^leaflet-locatecontrol-(.*)/dist/L.Control.Locate.css"         "cljsjs/common/leaflet-locate.inc.css"
                 #"^leaflet-locatecontrol-(.*)/dist/L.Control.Locate.mapbox.css"  "cljsjs/common/leaflet-locate-mapbox.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet-locatecontrol"
               :requires ["cljsjs.leaflet"])
    (pom)
    (jar)))