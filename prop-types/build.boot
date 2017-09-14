(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]
                  [cljsjs/react "15.6.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.5.10")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/prop-types
       :version     +version+
       :description "Runtime type checking for React props and similar objects"
       :url         "https://github.com/facebook/prop-types"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (format "https://unpkg.com/prop-types@%s/prop-types.js" +lib-version+))
    (download :url      (format "https://unpkg.com/prop-types@%s/prop-types.min.js" +lib-version+))
    (sift :move {#"^prop-types\.js"       "cljsjs/prop-types/development/prop-types.inc.js"
                 #"^prop-types\.min\.js"  "cljsjs/prop-types/production/prop-types.min.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
