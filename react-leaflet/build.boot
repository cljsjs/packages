(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.0" :scope "test"]
                  [cljsjs/react "15.6.1-2"]
                  [cljsjs/react-dom "15.6.1-2"]
                  [cljsjs/leaflet "1.1.0-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.5")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-leaflet
       :version     +version+
       :description "JavaScript Library for Mobile-Friendly Interactive Maps"
       :url         "https://github.com/PaulLeCam/react-leaflet"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (str "https://unpkg.com/react-leaflet@" +lib-version+ "/dist/react-leaflet.js")
              :checksum "9A5A94EDAF521D557F573B21CE2B3A9D")
    (download :url      (str "https://unpkg.com/react-leaflet@" +lib-version+ "/dist/react-leaflet.min.js")
              :checksum "96B51B1896661CFF7220908E0933FC94")
    (sift :move {#"^react-leaflet.js"      "cljsjs/react-leaflet/development/react-leaflet.inc.js"
                 #"^react-leaflet.min.js"  "cljsjs/react-leaflet/production/react-leaflet.min.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
