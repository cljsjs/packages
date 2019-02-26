(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.12.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/tfjs
       :version     +version+
       :description "A WebGL accelerated JavaScript library for training and deploying ML models."
       :url         "https://github.com/tensorflow/tfjs"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url (str "https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@" +lib-version+)
              :target "cljsjs/tfjs/development/tfjs.inc.js")
    (download :url (str "https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@" +lib-version+)
              :target "cljsjs/tfjs/production/tfjs.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.tfjs")
    (pom)
    (jar)
    (validate)))
