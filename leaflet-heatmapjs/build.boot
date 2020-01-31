(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/heatmapjs "2.0.5-0"]
                  [cljsjs/leaflet "1.5.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/leaflet-heatmapjs
       :version     +version+
       :description "Leaflet plugin for heatmapjs usage inside of leaflet."
       :url         "https://www.patrick-wied.at/static/heatmapjs/"
       :scm         {:url "https://github.com/pa7/heatmap.js/tree/master"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (format "http://unpkg.com/heatmap.js@%s/plugins/leaflet-heatmap/leaflet-heatmap.js" +lib-version+)
      :target "cljsjs/leaflet-heatmapjs/production/leaflet-heatmapjs.min.inc.js")
    (download
      :url (format "http://unpkg.com/heatmap.js@%s/plugins/leaflet-heatmap/leaflet-heatmap.js" +lib-version+)
      :target "cljsjs/leaflet-heatmapjs/development/leaflet-heatmapjs.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.leaflet-heatmapjs"
               :requires ["cljsjs.heatmapjs"
                          "cljsjs.leaflet"])
    (pom)
    (jar)
    (validate-checksums)))
