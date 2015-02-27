(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]
                  [cljsjs/d3 "3.5.5-1"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.3-1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/dimple
       :version     +version+
       :description "A JavaScript charting library based on d3"
       :url         "http://dimplejs.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url "https://raw.githubusercontent.com/PMSI-AlignAlytics/dimple/master/dist/dimple.v2.1.3.js"
             :checksum "F1189BD5961E043161930B5D2F38EA2A")
   (download :url "https://raw.githubusercontent.com/PMSI-AlignAlytics/dimple/master/dist/dimple.v2.1.3.min.js"
             :checksum "762301BED07A60A0A87A3D6128A6B5C6")
   (sift :move {#"^dimple\.v([\d+\.]*).js" "cljsjs/development/dimple.inc.js"
                #"^dimple\.v([\d+\.]*).min.js" "cljsjs/production/dimple.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dimple"
              :requires ["cljsjs.d3"])))
