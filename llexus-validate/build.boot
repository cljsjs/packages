(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.0-1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/llexus-validate
       :version     +version+
       :description "A simple validator for a subset of JSON-Schema."
       :url         "https://github.com/little-arhat/llexus-validate"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/little-arhat/llexus-validate/archive/0.1.0.zip"
              :checksum "5d16a0e3a75bb552c498d67c6a40213d"
              :unzip true)
    (sift :move {#"^llexus-validate-([\d\.-]*)/dist/llexus-validate\.js"      "cljsjs/llexus-validate/development/llexus-validate.inc.js"
                 #"^llexus-validate-([\d\.-]*)/dist/llexus-validate\.min\.js" "cljsjs/llexus-validate/production/llexus-validate.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.llexus-validate")))
