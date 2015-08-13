(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.1-0")
(bootlaces! +version+)

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/virtual-dom
       :version     +version+
       :description "A JavaScript DOM model supporting element creation, diff computation and patch operations for efficient re-rendering"
       :url         "https://github.com/Matt-Esch/virtual-dom"
       :license     {"License" "https://raw.githubusercontent.com/Matt-Esch/virtual-dom/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url "https://github.com/Matt-Esch/virtual-dom/archive/v2.1.1.zip"
             :checksum "afed7bc77deb53f2d8d1cbb26b094fa7"
             :unzip true)
   (sift :move {#"^virtual-dom-.*/dist/virtual-dom.js$" "cljsjs/development/virtual-dom.inc.js"})
   (minify :in "cljsjs/development/virtual-dom.inc.js" :out "cljsjs/production/virtual-dom.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.virtual-dom")))
