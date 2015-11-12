(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "4.9.0-1")
(bootlaces! +version+)

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
   (download  :url      "https://github.com/almende/vis/archive/v4.9.0.zip"
              :checksum "C94CE9A86F0DADE358BDDFB19700ABA3"
              :unzip    true)
   (sift      :move     {#"^vis(.*)/dist/vis.js"
                         "cljsjs/vis/development/vis.inc.js"
                         #"^vis(.*)/dist/vis.min.js"
                         "cljsjs/vis/production/vis.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.vis")))
