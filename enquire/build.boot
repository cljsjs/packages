(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.2-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/enquire
       :version     +version+
       :description " enquire.js is a lightweight, pure JavaScript library for responding to CSS media queries."
       :url         "http://wicky.nillia.ms/enquire.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url "https://github.com/WickyNilliams/enquire.js/archive/v2.1.2.zip"
             :checksum "d4817abff3cff26befb35736cb2e49f6"
             :unzip true)
   (sift :move {#"^enquire\.[^\/]*/dist/enquire.js" "cljsjs/enquire/development/enquire.inc.js"
                #"^enquire\.[^\/]*/dist/enquire.min.js" "cljsjs/enquire/production/enquire.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.enquire")))
