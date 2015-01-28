(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.2" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.5.3-1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/d3
       :version     +version+
       :description "D3.js packaged up with Google Closure externs"
       :url         "http://d3js.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/mbostock/d3/releases/download/v3.5.3/d3.zip"
              :checksum "1a479f146f9b6af33b5fb3dbd4d9736a"
              :unzip true)
    (sift :move {#"^d3.js" "cljsjs/development/d3.inc.js"
                 #"^d3.min.js" "cljsjs/production/d3.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.d3")))
