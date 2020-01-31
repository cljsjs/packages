(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.4.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/vis-network
      :version     +version+
      :description "Display dynamic, automatically organised, customizable network views."
      :url         "http://visjs.org/"
      :scm         {:url "https://github.com/visjs/vis-network"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"
                    "Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download  
    :url (format "https://unpkg.com/vis-network@%s/dist/vis-network.js" +lib-version+)
    :target "cljsjs/vis-network/development/vis-network.inc.js")
   (download
    :url (format "https://unpkg.com/vis-network@%s/dist/vis-network.min.js" +lib-version+)
    :target "cljsjs/vis-network/production/vis-network.min.inc.js")   
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.vis-network")
   (pom)
   (jar)
   (validate)))
