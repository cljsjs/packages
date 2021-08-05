(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/leaflet "1.7.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/leaflet-vectorgrid
       :version     +version+
       :description "Display gridded vector data (sliced GeoJSON or protobuf vector tiles) in Leaflet 1.0"
       :url         "https://github.com/Leaflet/Leaflet.VectorGrid"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"THE BEER-WARE LICENSE" "https://github.com/Leaflet/Leaflet.VectorGrid#legalese"}})

(deftask package []
  (comp
   (download :url      (str "https://unpkg.com/leaflet.vectorgrid@" +lib-version+ "/dist/Leaflet.VectorGrid.bundled.js")
             :target   "cljsjs/leaflet-vectorgrid/development/leaflet-vectorgrid.inc.js")
   (download :url      (str "https://unpkg.com/leaflet.vectorgrid@" +lib-version+ "/dist/Leaflet.VectorGrid.bundled.min.js")
             :target   "cljsjs/leaflet-vectorgrid/production/leaflet-vectorgrid.min.inc.js")
   (deps-cljs :provides ["cljsjs.leaflet-vectorgrid" "leaflet-vectorgrid"]
              :requires ["leaflet"]
              :global-exports '{leaflet-vectorgrid LeafletVectorGrid})
   (pom)
   (jar)
   (validate)))
