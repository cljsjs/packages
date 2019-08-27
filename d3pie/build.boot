(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/d3 "3.5.7-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3pie
       :version     +version+
       :description "A d3-based lib for creating pie charts"
       :url         "http://d3pie.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/benkeen/d3pie/archive/0.1.9.zip")
              :checksum "79C54BE7B3D9B901748276266AFFC4C2"
              :unzip true)
    (sift :move {#"^d3pie-.*/d3pie/d3pie\.js"      "cljsjs/d3pie/development/d3pie.inc.js"
                 #"^d3pie-.*/d3pie/d3pie\.min\.js" "cljsjs/d3pie/production/d3pie.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.d3pie")
    (pom)
    (jar)))
