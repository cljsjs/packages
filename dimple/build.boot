(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]
                  [cljsjs/d3 "3.5.5-1"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.2-0")
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
   (download :url "https://raw.githubusercontent.com/PMSI-AlignAlytics/dimple/2.1.2/dist/dimple.v2.1.2.js"
             :checksum "FD30B182DBF07FF8EF314CB1C734DC82")
   (download :url "https://raw.githubusercontent.com/PMSI-AlignAlytics/dimple/2.1.2/dist/dimple.v2.1.2.min.js"
             :checksum "C5D7EF47BA2445A130A00F3A9ABC1B78")
   (sift :move {#"^dimple\.v([\d+\.]*).js" "cljsjs/development/dimple.inc.js"
                #"^dimple\.v([\d+\.]*).min.js" "cljsjs/production/dimple.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dimple"
              :requires ["cljsjs.d3"])))
