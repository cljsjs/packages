(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/simplebar
       :version     +version+
       :description "Custom scrollbars vanilla javascript library with native scroll, cross-browser."
       :url         "http://grsmto.github.io/simplebar/"
       :scm         {:url "https://github.com/Grsmto/simplebar"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp

   ;; Development Files
   (download :url       (format "https://unpkg.com/simplebar@%s/dist/simplebar.css" +lib-version+)
             :target    "cljsjs/simplebar/development/simplebar.inc.css")
   (download :url       (format "https://unpkg.com/simplebar@%s/dist/simplebar.js" +lib-version+)
             :target    "cljsjs/simplebar/development/simplebar.inc.js")

   ;; Production Files
   (download :url       (format "https://unpkg.com/simplebar@%s/dist/simplebar.min.css" +lib-version+)
             :target    "cljsjs/simplebar/production/simplebar.inc.min.css")
   (download :url       (format "https://unpkg.com/simplebar@%s/dist/simplebar.min.js" +lib-version+)
             :target    "cljsjs/simplebar/production/simplebar.inc.min.js")

   (deps-cljs :name     "cljsjs.simplebar")
   (pom)
   (jar)
   (validate)))
