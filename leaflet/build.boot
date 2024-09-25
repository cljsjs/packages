(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.9.4")
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
   (download :url      (str "https://github.com/Leaflet/Leaflet/releases/download/v" +lib-version+ "/leaflet.zip")
             :unzip    true)
   (sift :move {#"^dist/leaflet-src.js$"    "cljsjs/leaflet/development/leaflet.inc.js"
                #"^dist/leaflet.js$"        "cljsjs/leaflet/production/leaflet.min.inc.js"
                #"^dist/leaflet.css$"       "cljsjs/leaflet/common/leaflet.inc.css"
                #"^dist/images/(.*\.png)$" "cljsjs/leaflet/common/images/$1"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["cljsjs.leaflet" "leaflet"]
              :global-exports '{leaflet L})
   (pom)
   (jar)
   (validate)))
