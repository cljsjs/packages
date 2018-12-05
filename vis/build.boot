(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.21.0")
(def +version+ (str +lib-version+ "-0"))

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
   (download  :url      (format "https://github.com/almende/vis/archive/v%s.zip" +lib-version+)
              :unzip    true)
   (sift      :move     {#"^vis(.*)/dist/vis.js"
                         "cljsjs/vis/development/vis.inc.js"
                         #"^vis(.*)/dist/vis.css"
                         "cljsjs/vis/development/vis.inc.css"
                         #"^vis(.*)/dist/vis.min.js"
                         "cljsjs/vis/production/vis.min.inc.js"
                         #"^vis(.*)/dist/vis.min.css"
                         "cljsjs/vis/production/vis.inc.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.vis")
   (pom)
   (jar)
   (validate-checksums)))
