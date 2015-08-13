(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/virtual-dom
       :version     +version+
       :description "Latest build of Matt-Esch/virtual-dom"
       :url         "http://github.com/Matt-Esch/virtual-dom"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/Matt-Esch/virtual-dom/master/dist/virtual-dom.js")
    (sift :move {#"^virtual-dom\.js"      "cljsjs/virtual-dom/development/virtual-dom.inc.js"})
    (minify :in  "cljsjs/virtual-dom/development/virtual-dom.inc.js"
            :out "cljsjs/virtual-dom/production/virtual-dom.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.virtual-dom")))
