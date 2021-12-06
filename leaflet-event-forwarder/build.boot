(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/leaflet "1.2.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/leaflet-event-forwarder
       :version     +version+
       :description (str "Catches unhandled canvas layer events and re-dispatches them to the next layer in the stack.")
       :url         "https://github.com/danwild/leaflet-event-forwarder"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/leaflet-event-forwarder@%s/dist/leaflet-event-forwarder.js" +lib-version+)
             :target "cljsjs/leaflet-event-forwarder/development/leaflet-event-forwarder.inc.js")
   (download :url (format "https://unpkg.com/leaflet-event-forwarder@%s/dist/leaflet-event-forwarder.js" +lib-version+)
             :target "cljsjs/leaflet-event-forwarder/production/leaflet-event-forwarder.min.inc.js")
   (deps-cljs :name "cljsjs.leaflet-event-forwarder"
              :requires ["cljsjs.leaflet"]
              )
   (pom)
   (jar)
   (validate)))
