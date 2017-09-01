(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react "15.6.1-2"]
                  [cljsjs/react-dom "15.6.1-2"]
                  [cljsjs/leaflet "1.1.0-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.5")
(def +version+ +lib-version+)

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
              :checksum "A4AD96D1827BCF42A2BF42B707297015"
              :unzip    true)
    (sift :move {#"^react-leaflet-(.*)/dist/react-leaflet.js"      "cljsjs/react-leaflet/development/react-leaflet.inc.js"
                 #"^react-leaflet-(.*)/dist/react-leaflet.min.js"  "cljsjs/react-leaflet/production/react-leaflet.min.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
