(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.91")
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
   (download  :url      "https://raw.githubusercontent.com/mrdoob/three.js/r91/build/three.js"
              :checksum "d762abdd39ac8bf82ed49e33223c9f16")
   (download  :url      "https://raw.githubusercontent.com/mrdoob/three.js/r91/build/three.min.js"
              :checksum "dbc882ea9757ed00f9c4bdbfaef851af")
   (sift      :move     {#"^three.js"
                         "cljsjs/three/development/three.inc.js"
                         #"^three.min.js"
                         "cljsjs/three/production/three.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.three")
   (pom)
   (jar)))
