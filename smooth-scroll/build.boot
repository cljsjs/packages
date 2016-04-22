(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/smooth-scroll
       :version     +version+
       :description "A simple vanilla JS script to animate scrolling to anchor links"
       :url         "https://github.com/cferdinandi/smooth-scroll"
       :scm         {:url "https://github.com/cferdinandi/smooth-scroll"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url      (str "https://github.com/cferdinandi/smooth-scroll/archive/v" +lib-version+ ".zip")
              :checksum "05BB3E3C87D76E7249A23AE2D0DEE09A"
              :unzip    true)
    (sift :move {#"^smooth-scroll-(.*)/dist/js/smooth-scroll.js"     "cljsjs/development/smooth-scroll.inc.js"
                 #"^smooth-scroll-(.*)/dist/js/smooth-scroll.min.js" "cljsjs/production/smooth-scroll.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.smooth-scroll")
    (pom)
    (jar)))
