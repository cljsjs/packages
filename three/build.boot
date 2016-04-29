(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.72")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/three
      :version     +version+
      :description "JavaScript 3D library"
      :url         "http://threejs.org/"
      :scm         {:url "https://github.com/mrdoob/three.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://raw.githubusercontent.com/mrdoob/three.js/r72/build/three.js"
              :checksum "e2bbc9da473919716d11964b1a3813d8")
   (download  :url      "https://raw.githubusercontent.com/mrdoob/three.js/r72/build/three.min.js"
              :checksum "130f3f943b1dffc0c682ecea913c92ba")
   (sift      :move     {#"^three.js"
                         "cljsjs/three/development/three.inc.js"
                         #"^three.min.js"
                         "cljsjs/three/production/three.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.three")
   (pom)
   (jar)))
