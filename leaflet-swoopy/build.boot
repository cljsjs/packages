(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/leaflet "1.5.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet-swoopy
       :version     +version+
       :description "A plugin for adding beautiful swoopy arrows on top of Leaflet maps"
       :url         "https://wbkd.github.io/leaflet-swoopy/"
       :scm         {:url "https://github.com/wbkd/leaflet-swoopy"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/leaflet-swoopy@%s/build/Leaflet.SwoopyArrow.js" +lib-version+)
             :target "cljsjs/leaflet-swoopy/development/leaflet-swoopy.inc.js")
   (download :url (format "https://unpkg.com/leaflet-swoopy@%s/build/Leaflet.SwoopyArrow.min.js" +lib-version+)
             :target "cljsjs/leaflet-swoopy/production/leaflet-swoopy.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["cljsjs.leaflet-swoopy"]
              :requires ["cljsjs.leaflet"])
   (pom)
   (jar)
   (validate)))
