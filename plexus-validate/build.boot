(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.4-1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/plexus-validate
       :version     +version+
       :description "A simple validator for a subset of JSON-Schema."
       :url         "https://github.com/AppliedMathematicsANU/plexus-validate"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/little-arhat/plexus-validate/archive/v0.0.4-1.zip"
              :checksum "5ef555889ec95ee310d642c9e6ed5648"
              :unzip true)
    (sift :move {#"^plexus-validate-([\d\.-]*)/dist/plexus-validate\.js"      "cljsjs/plexus-validate/development/plexus-validate.inc.js"
                 #"^plexus-validate-([\d\.-]*)/dist/plexus-validate\.min\.js" "cljsjs/plexus-validate/production/plexus-validate.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.plexus-validate")))
