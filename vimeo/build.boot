(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/vimeo
       :version     +version+
       :description "Vimeo.com Javascript SDK"
       :url         "https://github.com/vimeo/player.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Vimeo License" "https://github.com/vimeo/player.js/blob/master/LICENSE.md"}})

(deftask package []
  (comp
    (pom)
    (jar)))
