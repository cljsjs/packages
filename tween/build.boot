(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "16.3.1")
(bootlaces! +version+)

(task-options!
 pom {:project     'cljsjs/tween
      :version     +version+
      :description "JavaScript Tweening library"
      :url         "https://github.com/tweenjs/tween.js"
      :scm         {:url "https://github.com/tweenjs/tween.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://raw.githubusercontent.com/tweenjs/tween.js/v16.3.1/src/Tween.js"
              :checksum "a8a1b8f1cf9d40aca36bb51e7039b59a")
   (sift      :move     {#"^Tween.js"
                         "cljsjs/tween/development/tween.inc.js" })
   (minify :in "cljsjs/tween/development/tween.inc.js"
           :out "cljsjs/tween/production/tween.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.tween")))
