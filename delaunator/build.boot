(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.2")

(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/delaunator
       :version     +version+
       :description "fast JavaScript library for Delaunay triangulation of 2D points"
       :url         "https://mapbox.github.io/delaunator"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
     :url (format "https://unpkg.com/delaunator@%s/delaunator.js" +lib-version+))
    (download
     :url (format "https://unpkg.com/delaunator@%s/delaunator.min.js" +lib-version+))
    (sift :move {#".*delaunator\.js$"      "cljsjs/delaunator/development/delaunator.inc.js"})
    (sift :move {#".*delaunator\.min\.js$" "cljsjs/delaunator/production/delaunator.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.delaunator")
    (pom)
    (jar)
    (validate)))
