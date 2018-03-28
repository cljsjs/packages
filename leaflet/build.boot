(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet
       :version     +version+
       :description "JavaScript Library for Mobile-Friendly Interactive Maps"
       :url         "http://leafletjs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
   (download :url      (str "https://github.com/Leaflet/Leaflet/archive/v" +lib-version+ ".zip")
             :checksum "5F9DDB59B2C68E40B58467D508AC7F3E"
             :unzip    true)
   (sift :move {#"^Leaflet-(.*)/dist/leaflet-src.js"    "cljsjs/leaflet/development/leaflet.inc.js"
                #"^Leaflet-(.*)/dist/leaflet.js"        "cljsjs/leaflet/production/leaflet.min.inc.js"
                #"^Leaflet-(.*)/dist/leaflet.css"       "cljsjs/leaflet/common/leaflet.inc.css"
                #"^Leaflet-(.*)/dist/images/(.*\.png)$" "cljsjs/leaflet/common/images/$2"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["cljsjs.leaflet" "leaflet"]
              :global-exports '{leaflet L})
   (pom)
   (jar)))
