(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/bezier-easing
       :version     +version+
       :description "Cubic-bezier implementation for your JavaScript animation easings"
       :url         "https://github.com/gre/bezier-easing"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/license/MIT/"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/bezier-easing@%s/dist/bezier-easing.js" +lib-version+)
             :target "cljsjs/bezier-easing/development/bezier-easing.inc.js")
   (download :url (format "https://unpkg.com/bezier-easing@%s/dist/bezier-easing.min.js" +lib-version+)
             :target "cljsjs/bezier-easing/production/bezier-easing.min.inc.js")
   (deps-cljs :provides ["bezier-easing" "cljsjs.bezier-easing"])
   (pom)
   (jar)
   (validate-checksums)))
