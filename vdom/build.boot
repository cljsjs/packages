(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/vdom
       :version     +version+
       :description "A ClojureScript wrapper for Matt-Esch/virtual-dom"
       :url         "http://github.com/exupero/vdom"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/exupero/vdom/master/vdom.js")
    (download :url "https://raw.githubusercontent.com/exupero/vdom/master/vdom.min.js")
    (sift :move {#"^vdom\.js"      "cljsjs/vdom/development/vdom.inc.js"
                 #"^vdom\.min\.js" "cljsjs/vdom/production/vdom.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vdom")))
