(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/heatmapjs
       :version     +version+
       :description "heatmap.js is a lightweight, easy to use JavaScript library to help you visualize your three dimensional data!"
       :url         "https://www.patrick-wied.at/static/heatmapjs/"
       :scm         {:url "https://github.com/pa7/heatmap.js/tree/master"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (format "http://unpkg.com/heatmap.js@%s/build/heatmap.min.js" +lib-version+)
      :target "cljsjs/heatmapjs/production/heatmapjs.min.inc.js")
    (download
      :url (format "http://unpkg.com/heatmap.js@%s/build/heatmap.js" +lib-version+)
      :target "cljsjs/heatmapjs/development/heatmapjs.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.heatmapjs")
    (pom)
    (jar)
    (validate-checksums)))
