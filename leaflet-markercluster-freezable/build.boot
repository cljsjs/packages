(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/leaflet "1.5.1-0"]
                 [cljsjs/leaflet-markercluster "1.3.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet-markercluster-freezable
       :version     +version+
       :description (str "Sub-plugin for Leaflet.markercluster plugin (MCG in short); adds the ability to freeze clusters at a specified zoom.")
       :url         "https://github.com/ghybs/Leaflet.MarkerCluster.Freezable"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/leaflet.markercluster.freezable@%s/dist/leaflet.markercluster.freezable-src.js" +lib-version+)
             :target "cljsjs/leaflet-markercluster-freezable/development/leaflet-markercluster-freezable.inc.js")
   (download :url (format "https://unpkg.com/leaflet.markercluster.freezable@%s/dist/leaflet.markercluster.freezable.js" +lib-version+)
             :target "cljsjs/leaflet-markercluster-freezable/production/leaflet-markercluster-freezable.min.inc.js")
   (deps-cljs :name "cljsjs.leaflet-markercluster-freezable"
              :requires ["cljsjs.leaflet"
                         "cljsjs.leaflet-markercluster"])
   (pom)
   (jar)
   (validate)))
