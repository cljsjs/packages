(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.11.5")
(def +version+ (str +lib-version+))

(task-options!
  pom {:project     'cljsjs/tfjs
       :version     +version+
       :description "A WebGL accelerated JavaScript library for training and deploying ML models."
       :url         "https://github.com/tensorflow/tfjs"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (pom)
    (jar)
    (validate-checksums)))
