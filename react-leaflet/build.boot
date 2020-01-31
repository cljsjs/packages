(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.8.0-0"]
                  [cljsjs/react-dom "16.8.0-0"]
                  [cljsjs/leaflet "1.5.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-leaflet
       :version     +version+
       :description "JavaScript Library for Mobile-Friendly Interactive Maps"
       :url         "https://github.com/PaulLeCam/react-leaflet"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url      (str "https://unpkg.com/react-leaflet@" +lib-version+ "/dist/react-leaflet.js")
              :target   "cljsjs/react-leaflet/development/react-leaflet.inc.js")
    (download :url      (str "https://unpkg.com/react-leaflet@" +lib-version+ "/dist/react-leaflet.min.js")
              :target   "cljsjs/react-leaflet/production/react-leaflet.min.inc.js")
    (deps-cljs :provides ["react-leaflet" "cljsjs.react-leaflet"]
               :requires ["leaflet" "react" "react-dom"]
               :global-exports '{react-leaflet ReactLeaflet})
    (pom)
    (jar)
    (validate)))
