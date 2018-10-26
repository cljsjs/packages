(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "10.2.1")
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
              :checksum "F36BEBA95B7F1089CF1E0E0844BB8AAD"
              :unzip    true)
    (sift :move {#"^smooth-scroll-(.*)/dist/js/smooth-scroll.js"     "cljsjs/development/smooth-scroll.inc.js"
                 #"^smooth-scroll-(.*)/dist/js/smooth-scroll.min.js" "cljsjs/production/smooth-scroll.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.smooth-scroll")
    (pom)
    (jar)))
