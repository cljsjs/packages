(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/tfjs-vis
      :version     +version+
      :description "Utilities for in browser visualization with TensorFlow.js"
      :url         "https://github.com/tensorflow/tfjs/tree/master/tfjs-vis"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str "https://cdn.jsdelivr.net/npm/@tensorflow/tfjs-vis@" +lib-version+ "/dist/tfjs-vis.umd.min.js") 
             :target "cljsjs/tfjs-vis/development/tfjs-vis.inc.js")
   (download :url (str "https://cdn.jsdelivr.net/npm/@tensorflow/tfjs-vis@" +lib-version+ "/dist/tfjs-vis.umd.min.js")
             :target "cljsjs/tfjs-vis/production/tfjs-vis.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.tfjs-vis")
   (pom)
   (jar)
   (validate)))
