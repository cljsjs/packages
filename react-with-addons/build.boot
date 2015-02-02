(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.3" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.12.2-4")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-with-addons
       :version     +version+
       :description "React.js with addons packaged up with Google Closure externs"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/facebook/react/releases/download/v0.12.2/react-0.12.2.zip"
              :checksum "6a242238790b21729a88c26145eca6b9"
              :unzip true)
    (sift :move {#"^react-.*/build/react-with-addons.js" "cljsjs/development/react-with-addons.inc.js"
                 #"^react-.*/build/react-with-addons.min.js" "cljsjs/production/react-with-addons.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react")))
