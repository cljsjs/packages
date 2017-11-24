(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/proj4leaflet
       :version     +version+
       :description "Smooth Proj4js integration with Leaflet"
       :url         "http://kartena.github.io/Proj4Leaflet/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/proj4leaflet@%s/src/proj4leaflet.js" +lib-version+)
              :target "cljsjs/proj4leaflet/development/proj4leaflet.inc.js")

    (deps-cljs :provides ["proj4leaflet" "cljsjs.proj4leaflet"]
               :requires ["proj4"]
               :global-exports '{proj4leaflet L.Proj})
    (pom)
    (jar)))
