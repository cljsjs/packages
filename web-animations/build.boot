(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/web-animations
       :version     +version+
       :description "A polyfill for Web Animations"
       :url         "https://github.com/web-animations/web-animations-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/web-animations/web-animations-js/archive/" +lib-version+ ".zip") :unzip true)
    (sift :move {#"^web-animations-js-([\d\.]*)/web-animations.min.js$"
                 "cljsjs/web-animations/development/web-animations-js.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.web-animations")))
