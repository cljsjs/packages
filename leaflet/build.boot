(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.3")
(def +version+ (str +lib-version+ "-6"))

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
              :checksum "8C9DFA841C49E96D0AF830713F945510"
              :unzip    true)
    (sift :move {#"^Leaflet-(.*)/dist/leaflet-src.js"    "cljsjs/development/leaflet.inc.js"
                 #"^Leaflet-(.*)/dist/leaflet.js"        "cljsjs/production/leaflet.min.inc.js"
                 #"^Leaflet-(.*)/dist/leaflet.css"       "cljsjs/common/leaflet.inc.css"
                 #"^Leaflet-(.*)/dist/images/(.*\.png)$" "cljsjs/common/images/$2"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet")))
