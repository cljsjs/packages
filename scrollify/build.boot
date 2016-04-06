(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.12")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/scrollify
       :version     +version+
       :description "A jQuery plugin that assists scrolling and smoothly snaps to sections. Fully configurable and optimised for touch."
       :url         "https://github.com/lukehaas/Scrollify"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (format "https://github.com/lukehaas/Scrollify/archive/%s.zip" +lib-version+)
             :checksum "ADC6E95771775807261571E443CE91EC"
             :unzip    true)
   (sift :move {(re-pattern (str "^Scrollify-" +lib-version+ "/jquery.scrollify.js$"))  "cljsjs/scrollify/development/scrollify.inc.js"
                (re-pattern (str "^Scrollify-" +lib-version+ "/jquery.scrollify.min.js$"))  "cljsjs/scrollify/production/scrollify.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.scrollify"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
