(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/leaflet "0.7.7-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.12.3")
(def +version+ (str +lib-version+ "-2"))

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
    (download :url      (str "https://github.com/PaulLeCam/react-leaflet/archive/v" +lib-version+ ".zip")
              :checksum "0783AB13D2FD32C8566F0FF4B0AD101A"
              :unzip    true)
    (sift :move {#"^react-leaflet-(.*)/dist/react-leaflet.js"      "cljsjs/development/react-leaflet.inc.js"
                 #"^react-leaflet-(.*)/dist/react-leaflet.min.js"  "cljsjs/production/react-leaflet.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-leaflet"
               :requires ["cljsjs.react" "cljsjs.leaflet"])
    (pom)
    (jar)))
