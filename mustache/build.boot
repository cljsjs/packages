(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.1.0-0")

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
    (download :url      "https://github.com/janl/mustache.js/archive/v1.1.0.zip"
              :checksum "fe10b20e3a4cea190725ebbbbe5a5890"
              :unzip    true)
    (sift :move {#"^mustache.js-\d.\d.\d/mustache.js$"     "cljsjs/mustache/development/mustache.inc.js"
                 #"^mustache.js-\d.\d.\d/mustache.min.js$" "cljsjs/mustache/production/mustache.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mustache")))
