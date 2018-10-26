(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/leaflet "1.2.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet-markercluster
       :version     +version+
       :description (str "Provides Beautiful Animated Marker Clustering functionality for Leaflet, a JS library for interactive maps.")
       :url         "https://github.com/Leaflet/Leaflet.markercluster"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/leaflet.markercluster@%s/dist/leaflet.markercluster-src.js" +lib-version+)
             :target "cljsjs/leaflet-markercluster/development/leaflet-markercluster.inc.js")
   (download :url (format "https://unpkg.com/leaflet.markercluster@%s/dist/leaflet.markercluster.js" +lib-version+)
             :target "cljsjs/leaflet-markercluster/production/leaflet-markercluster.min.inc.js")
   (download :url (format "https://unpkg.com/leaflet.markercluster@%s/dist/MarkerCluster.Default.css" +lib-version+)
             :target "cljsjs/leaflet-markercluster/common/leaflet-markercluster.default.inc.css")
   (download :url (format "https://unpkg.com/leaflet.markercluster@%s/dist/MarkerCluster.css" +lib-version+)
             :target "cljsjs/leaflet-markercluster/common/leaflet-markercluster.inc.css")
   (deps-cljs :name "cljsjs.leaflet-markercluster"
              :requires ["cljsjs.leaflet"]
              )
   (pom)
   (jar)
   (validate-checksums)))
