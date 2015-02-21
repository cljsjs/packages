(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.0.4-2")

(task-options!
 pom  {:project     'cljsjs/hammer
       :version     +version+
       :description "Hammer.js packaged up with Google Closure externs"
       :url         "http://hammerjs.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/hammerjs/hammer.js/archive/2.0.4.zip"
              :checksum "11fe50c17ced2808cffec81f80833d54"
              :unzip true)
    (sift :move {#"^hammer.js-(.*)/hammer.js"     "cljsjs/development/hammer.inc.js"
                 #"^hammer.js-(.*)/hammer.min.js" "cljsjs/production/hammer.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hammer")))
