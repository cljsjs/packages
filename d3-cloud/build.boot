(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/d3          "3.5.5-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.1")
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
   (download :url (str "https://github.com/jasondavies/d3-cloud/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^d3-cloud-([\d\.]*)/build/d3\.layout\.cloud\.js" "cljsjs/d3-cloud/development/cloud.inc.js"})

   (minify :in "cljsjs/d3-cloud/development/cloud.inc.js"
               :out "cljsjs/d3-cloud/production/cloud.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-cloud"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
