(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/smartcrop
       :version     +version+
       :description "Smartcrop.js implements an algorithm to find good crops for images"
       :url         "https://github.com/jwagner/smartcrop.js"
       :scm         {:url "https://github.com/jwagner/smartcrop.js"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (str "https://raw.githubusercontent.com/jwagner/smartcrop.js/v" +lib-version+ "/smartcrop.js")
              :checksum "61D1933533C8814820B2D90727506ACB"
              :unzip    false)
    (sift :move {#"^smartcrop\.js"    "cljsjs/smartcrop/common/smartcrop.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.smartcrop")
    (pom)
    (jar)))
