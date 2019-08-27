(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/slip
       :version     +version+
       :description "A tiny library for interactive swiping and reordering of elements in lists on touch screens"
       :url         "https://github.com/pornel/slip"
       :scm         {:url "https://github.com/pornel/slip"}
       :license     {"MIT" "https://opensource.org/licenses/BSD-3-Clause"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (str "https://raw.githubusercontent.com/pornel/slip/v" +lib-version+ "/slip.js")
              :checksum "87507849AF3AA24ED8F082E482661492"
              :unzip    false)
    (sift :move {#"^slip\.js"    "cljsjs/slip/common/slip.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.slip")
    (pom)
    (jar)))
