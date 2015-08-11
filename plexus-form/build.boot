(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react       "0.13.0-0"]
                  ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.3-1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/plexus-form
       :version     +version+
       :description "A dynamic form component for React using a specification format based on JSON-Schema."
       :url         "https://github.com/AppliedMathematicsANU/plexus-form"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url "https://github.com/little-arhat/plexus-form/archive/v0.1.3-1.zip"
              :checksum "e163bf04497a1c0eae176d3cd98fa0da"
              :unzip true)
   (sift :move {#"^plexus-form-([\d\.-]*)/dist/plexus-form\.js"      "cljsjs/plexus-form/development/plexus-form.inc.js"
                #"^plexus-form-([\d\.-]*)/dist/plexus-form\.min\.js" "cljsjs/plexus-form/production/plexus-form.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.plexus-form"
               :requires ["cljsjs.react"])))
