(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/leaflet "0.7.7-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.8")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/leaflet-gesture-handling
        :version     +version+
        :description "Brings the basic functionality of Google Maps Gesture Handling into Leaflet."
        :url         "https://github.com/elmarquis/Leaflet.GestureHandling"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/leaflet-gesture-handling@%s/dist/leaflet-gesture-handling.js" +lib-version+)
             :target "cljsjs/leaflet-gesture-handling/development/leaflet-gesture-handling.inc.js")
   (download :url (format "https://unpkg.com/leaflet-gesture-handling@%s/dist/leaflet-gesture-handling.min.js" +lib-version+)
             :target "cljsjs/leaflet-gesture-handling/production/leaflet-gesture-handling.min.inc.js")
   (download :url (format "https://unpkg.com/leaflet-gesture-handling@%s/dist/leaflet-gesture-handling.css" +lib-version+)
             :target "cljsjs/leaflet-gesture-handling/common/leaflet-gesture-handling.inc.css")
   (download :url (format "https://unpkg.com/leaflet-gesture-handling@%s/dist/leaflet-gesture-handling.min.css" +lib-version+)
             :target "cljsjs/leaflet-gesture-handling/common/leaflet-gesture-handling.min.inc.css")
   (deps-cljs :name "cljsjs.leaflet-gesture-handling"
              :requires ["cljsjs.leaflet"])
   (pom)
   (jar)
   (validate)))
