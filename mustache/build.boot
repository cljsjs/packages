(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/mustache
       :version     +version+
       :description "Minimal templating with {{mustaches}} in JavaScript"
       :url         "https://github.com/janl/mustache.js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (format "https://github.com/janl/mustache.js/archive/v%s.zip" +lib-version+)
              :checksum "fe10b20e3a4cea190725ebbbbe5a5890"
              :unzip    true)
    (sift :move {#"^mustache.js-\d.\d.\d/mustache.js$"     "cljsjs/mustache/development/mustache.inc.js"
                 #"^mustache.js-\d.\d.\d/mustache.min.js$" "cljsjs/mustache/production/mustache.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mustache")
    (pom)
    (jar)))
