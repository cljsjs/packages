(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.4.7" :scope "test"]
                 [adzerk/bootlaces "0.1.11" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[adzerk.bootlaces :refer :all])

(def +version+ "0.8.0-0")
(bootlaces! +version+)

(task-options!
 pom {:project 'cljsjs/matter
      :version +version+
      :description "Matter.js is a JavaScript 2D rigid body physics engine for the web"
      :url "http://brm.io/matter-js/"
      :scm { :url "https://github.com/liabru/matter-js" }
      :license { "MIT" "https://github.com/liabru/matter-js/blob/master/LICENSE" }})

(deftask package []
  (comp
   (download :url "https://github.com/liabru/matter-js/archive/0.8.0-alpha.zip"
             :checksum "839AE18144E391943F995D1FC579A8ED"
             :unzip true)
   (sift :move {#"^.*/build/matter.js$" "cljsjs/matter/development/matter.inc.js"
                #"^.*/build/matter.min.js$" "cljsjs/matter/production/matter.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.matter")))
