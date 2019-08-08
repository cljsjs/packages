(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
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
              :checksum "58ed2f543954aaaea2c80d2530dd5aa6"
              :unzip    true)
    (sift :move {#"^mustache.js-\d.\d.\d/mustache.js$"     "cljsjs/mustache/development/mustache.inc.js"
                 #"^mustache.js-\d.\d.\d/mustache.min.js$" "cljsjs/mustache/production/mustache.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mustache")
    (pom)
    (jar)))
