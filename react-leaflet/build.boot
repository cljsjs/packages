(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/leaflet "0.7.7-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.1")
(def +version+ (str +lib-version+ "-0"))

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
              :checksum "A95A2E30EA383339297327D03ED1C00A"
              :unzip    true)
    (sift :move {#"^react-leaflet-(.*)/dist/react-leaflet.js"      "cljsjs/development/react-leaflet.inc.js"
                 #"^react-leaflet-(.*)/dist/react-leaflet.min.js"  "cljsjs/production/react-leaflet.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-leaflet"
               :requires ["cljsjs.react" "cljsjs.leaflet"])
    (pom)
    (jar)))
