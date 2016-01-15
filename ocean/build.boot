(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
; FIXME: Next release should have build identier
(def +version+ (str +lib-version+ ""))

(task-options!
 pom {:project     'cljsjs/ocean
      :version     +version+
      :description "ThreeJS Ocean (water material)"
      :url         "https://github.com/jbouny/ocean"
      :scm         {:url "https://github.com/jbouny/ocean"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://raw.githubusercontent.com/jbouny/ocean/d5e5f4bd2fe7122fda787458800bba4836aad2a1/water-material.js"
              :checksum "01B418D412777356A200DA963AFE999E")
   (sift      :move     {#"^water-material.js"
                         "cljsjs/ocean/development/water-material.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.ocean"
              :requires ["cljsjs.three"])))
