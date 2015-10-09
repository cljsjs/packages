(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.72")
(bootlaces! +version+)

(task-options!
 pom {:project     'cljsjs/three
      :version     +version+
      :description "JavaScript 3D library. This build has CSS3D support packaged"
      :url         "http://threejs.org/"
      :scm         {:url "https://github.com/mrdoob/three.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "http://localhost:8000/three.js-all.zip"
              :checksum "faf62448f424cc66977b9a398c73cd0b"
              :unzip    true))
   (sift      :move     {#"^three\.js(.*)/build/three.js"
                         "cljsjs/three/development/three.inc.js"
                         #"^three\.js(.*)/build/three.min.js"
                         "cljsjs/three/production/three.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.three")))
