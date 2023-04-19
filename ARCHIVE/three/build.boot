(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.01")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/three
      :version     +version+
      :description "JavaScript 3D library"
      :url         "http://threejs.org/"
      :scm         {:url "https://github.com/mrdoob/three.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://raw.githubusercontent.com/mrdoob/three.js/r101/build/three.js")
   (download  :url      "https://raw.githubusercontent.com/mrdoob/three.js/r101/build/three.min.js")
   (sift      :move     {#"^three.js"
                         "cljsjs/three/development/three.inc.js"
                         #"^three.min.js"
                         "cljsjs/three/production/three.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.three")
   (pom)
   (jar)
   (validate)))
