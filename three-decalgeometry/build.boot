(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/three-decalgeometry
      :version     +version+
      :description "Decal Geometry for three.js"
      :url         "https://github.com/spite/THREE.DecalGeometry"
      :scm         {:url "https://github.com/spite/THREE.DecalGeometry"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://raw.githubusercontent.com/spite/THREE.DecalGeometry/546cebafebd34b4b10cc47c2d6412310e6372159/src/THREE.DecalGeometry.js"
              :checksum "508d58a0ab13c95d040a32a13581d0ce")
   (sift      :move     {#"^THREE.DecalGeometry.js"
                         "cljsjs/three-decalgeometry/development/THREE.DecalGeometry.inc.js"})
   (minify    :in       "cljsjs/three-decalgeometry/development/THREE.DecalGeometry.inc.js"
              :out      "cljsjs/three-decalgeometry/production/THREE.DecalGeometry.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.three-decalgeometry"
              :requires ["cljsjs.three"])
   (pom)
   (jar)))
