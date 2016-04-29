(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.7")
(def +version+ (str +lib-version+ "-3"))

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
              :checksum "4FF0060F12AEC757C6DAA1D7AD1BD88E"
              :unzip    true)
    (sift :move {#"^Leaflet-(.*)/dist/leaflet-src.js"    "cljsjs/development/leaflet.inc.js"
                 #"^Leaflet-(.*)/dist/leaflet.js"        "cljsjs/production/leaflet.min.inc.js"
                 #"^Leaflet-(.*)/dist/leaflet.css"       "cljsjs/common/leaflet.inc.css"
                 #"^Leaflet-(.*)/dist/images/(.*\.png)$" "cljsjs/common/images/$2"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet")
    (pom)
    (jar)))
