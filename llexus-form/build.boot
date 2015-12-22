(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react       "0.13.0-0"]
                  ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.7.1-1")

(task-options!
 pom  {:project     'cljsjs/llexus-form
       :version     +version+
       :description "A dynamic form component for React using a specification format based on JSON-Schema."
       :url         "https://github.com/little-arhat/llexus-form"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url "https://github.com/little-arhat/llexus-form/archive/0.7.1.zip"
              :checksum "21e684a951ac800cca1ff67d443f466f"
              :unzip true)
   (sift :move {#"^llexus-form-([\d\.-]*)/dist/llexus-form\.js"      "cljsjs/llexus-form/development/llexus-form.inc.js"
                #"^llexus-form-([\d\.-]*)/dist/llexus-form\.min\.js" "cljsjs/llexus-form/production/llexus-form.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.llexus-form"
               :requires ["cljsjs.react"])))
