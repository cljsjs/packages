(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/leaflet "1.7.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/esri-leaflet
       :version     +version+
       :description (str "A lightweight set of tools for working with ArcGIS services in Leaflet.")
       :url         "https://github.com/Esri/esri-leaflet/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache License 2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/esri-leaflet@%s/dist/esri-leaflet-debug.js" +lib-version+)
             :target "cljsjs/esri-leaflet/development/esri-leaflet.inc.js")
   (download :url (format "https://unpkg.com/esri-leaflet@%s/dist/esri-leaflet.js" +lib-version+)
             :target "cljsjs/esri-leaflet/production/esri-leaflet.min.inc.js")
   (deps-cljs :name "cljsjs.esri-leaflet"
              :requires ["cljsjs.leaflet"]
              )
   (pom)
   (jar)
   (validate)))
