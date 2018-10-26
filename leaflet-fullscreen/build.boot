(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/leaflet-fullscreen
       :version     +version+
       :description "A fullscreen control for Leaflet"
       :url         "http://leaflet.github.io/Leaflet.fullscreen/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (str "https://github.com/Leaflet/Leaflet.fullscreen/archive/v" +lib-version+ ".zip")
             :unzip    true)
   (sift :move {#"^Leaflet.fullscreen-(.*)/dist/Leaflet.fullscreen.js"     "cljsjs/leaflet-fullscreen/development/leaflet-fullscreen.inc.js"
                #"^Leaflet.fullscreen-(.*)/dist/Leaflet.fullscreen.min.js" "cljsjs/leaflet-fullscreen/production/leaflet-fullscreen.min.inc.js"
                #"^Leaflet.fullscreen-(.*)/dist/leaflet.fullscreen.css"    "cljsjs/leaflet-fullscreen/common/leaflet-fullscreen.inc.css"
                #"^Leaflet.fullscreen-(.*)/dist/(.*\.png)$"                "cljsjs/leaflet-fullscreen/common/$2"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (deps-cljs :provides ["leaflet-fullscreen" "cljsjs.leaflet-fullscreen"]
              :requires ["leaflet"]
              :global-exports '{leaflet-fullscreen L.Control.Fullscreen})
   (pom)
   (jar)))
