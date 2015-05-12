(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.7.3-2")

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
    (download :url      "https://github.com/Leaflet/Leaflet/archive/v0.7.3.zip"
              :checksum "03cb648ca04cc7b42ea5cc16004908b6"
              :unzip    true)
    (sift :move {#"^Leaflet-(.*)/dist/leaflet-src.js"    "cljsjs/development/leaflet.inc.js"
                 #"^Leaflet-(.*)/dist/leaflet.js"        "cljsjs/production/leaflet.min.inc.js"
                 #"^Leaflet-(.*)/dist/leaflet.css"       "cljsjs/common/leaflet.inc.css"
                 #"^Leaflet-(.*)/dist/images/(.*\.png)$" "cljsjs/common/images/$2"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet")))
