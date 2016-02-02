(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "4.11.0-1")

(task-options!
 pom {:project     'cljsjs/vis
      :version     +version+
      :description "Dynamic, browser-based visualization library"
      :url         "http://visjs.org/"
      :scm         {:url "https://github.com/almende/vis"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"
                    "Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download  :url      "https://github.com/almende/vis/archive/v4.11.0.zip"
              :checksum "28E85C1C8E8B18C289D1780438F90AE6"
              :unzip    true)
   (sift      :move     {#"^vis(.*)/dist/vis.js"
                         "cljsjs/vis/development/vis.inc.js"
                         #"^vis(.*)/dist/vis.min.js"
                         "cljsjs/vis/production/vis.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.vis")))
