(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.6.18-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/topojson
       :version     +version+
       :description "topojson packaged up with Google Closure externs"
       :url         "https://github.com/mbostock/topojson"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD-like I think?" "https://github.com/mbostock/topojson/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "https://github.com/mbostock/topojson/releases/download/v1.6.18/topojson-js.zip"
             :checksum "4b74a159ad97bc9f0ca514093ed327bc"
             :unzip true)
    (sift :move {#"^topojson.js" "cljsjs/development/topojson.inc.js"
                 #"^topojson.min.js" "cljsjs/production/topojson.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.topojson"
               :requires ["cljsjs.d3"])))
