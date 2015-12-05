(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.0.0")
(bootlaces! +version+)

(task-options!
 pom {:project     'cljsjs/three-water-material
      :version     +version+
      :description "ThreeJS water material"
      :url         "https://github.com/jbouny/ocean"
      :scm         {:url "https://github.com/jbouny/ocean"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://raw.githubusercontent.com/jbouny/ocean/d5e5f4bd2fe7122fda787458800bba4836aad2a1/water-material.js"
              :checksum "01B418D412777356A200DA963AFE999E")
   (sift      :move     {#"^water-material.js"
                         "cljsjs/three-water-material/development/three-water-material.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.three-water-material"
              :requires ["cljsjs.three"])))
