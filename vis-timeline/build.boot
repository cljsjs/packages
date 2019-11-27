(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/vis-timeline
      :version     +version+
      :description "The Timeline/Graph2D is an interactive visualization chart to visualize data in time"
      :url         "https://visjs.github.io/vis-timeline/"
      :scm         {:url "https://github.com/visjs/vis-timeline"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"
                    "Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/vis-timeline@%s/dist/vis-timeline-graph2d.min.js" +lib-version+)
             :target "cljsjs/vis-timeline/development/vis-timeline.inc.js")
   (download :url (format "https://unpkg.com/vis-timeline@%s/dist/vis-timeline-graph2d.css" +lib-version+)
             :target "cljsjs/vis-timeline/development/vis-timeline.inc.css")
   (download :url (format "https://unpkg.com/vis-timeline@%s/dist/vis-timeline-graph2d.min.css" +lib-version+)
             :target "cljsjs/vis-timeline/production/vis-timeline.min.inc.css")   
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.vis-timeline")
   (pom)
   (jar)
   (validate)))
