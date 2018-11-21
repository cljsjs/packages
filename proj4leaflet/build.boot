(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/proj4 "2.5.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.2")
(def +version+ (str +lib-version+ "-1"))

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
