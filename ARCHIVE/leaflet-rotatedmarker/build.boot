(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet-rotatedmarker
       :version     +version+
       :description "Enables rotation of marker icons in Leaflet."
       :url         "https://github.com/bbecquet/Leaflet.RotatedMarker"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (str "https://unpkg.com/leaflet-rotatedmarker@" +lib-version+ "/leaflet.rotatedMarker.js")
             :target   "cljsjs/leaflet-rotatedmarker/development/leaflet-rotatedMarker.inc.js")
   (minify :in  "cljsjs/leaflet-rotatedmarker/development/leaflet-rotatedMarker.inc.js"
           :out "cljsjs/leaflet-rotatedmarker/production/leaflet-rotatedMarker.min.js")
   (deps-cljs :provides ["leaflet-rotatedmarker" "cljsjs.leaflet-rotatedmarker"]
              :requires ["leaflet"]
              :global-exports '{leaflet-rotatedmarker Leaflet.RotatedMarker})
   (pom)
   (jar)))
