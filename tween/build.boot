(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16.3.1")
; FIXME: Next release should have build identier
(def +version+ (str +lib-version+ ""))

(task-options!
 pom {:project     'cljsjs/tween
      :version     +version+
      :description "JavaScript Tweening library"
      :url         "https://github.com/tweenjs/tween.js"
      :scm         {:url "https://github.com/tweenjs/tween.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://raw.githubusercontent.com/tweenjs/tween.js/v%s/src/Tween.js" +lib-version+)
              :checksum "a8a1b8f1cf9d40aca36bb51e7039b59a")
   (sift      :move     {#"^Tween.js"
                         "cljsjs/tween/development/tween.inc.js" })
   (minify :in "cljsjs/tween/development/tween.inc.js"
           :out "cljsjs/tween/production/tween.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.tween")))
