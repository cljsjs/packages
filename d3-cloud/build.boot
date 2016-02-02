(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/d3          "3.5.5-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3-cloud
       :version     +version+
       :description "nil"
       :url         "nil"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://www.opensource.org/licenses/mit-license.php"}})

(deftask package []
  (comp
   (download :url "https://cdn.rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js")
   (sift :move {#"d3.layout.cloud.js" "cljsjs/d3-cloud/development/cloud.inc.js"})
   (download :url "https://cdn.rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js")
   (sift :move {#"d3.layout.cloud.js" "cljsjs/d3-cloud/production/cloud.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-cloud"
              :requires ["cljsjs.d3"])))
