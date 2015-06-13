(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.6.18-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/topojson
       :version     +version+
       :description "An extension to GeoJSON that encodes topology"
       :url         "https://github.com/mbostock/topojson"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Bostock" "https://github.com/mbostock/topojson/blob/v1.6.18/LICENSE"}})

(deftask package []
  (comp
   (download  :url      "https://github.com/mbostock/topojson/archive/v1.6.18.zip"
              :checksum "036a19607242e00de0222d103febd161"
              :unzip    true)
   (sift      :move     {#"^topojson-.*/topojson.js"
                         "cljsjs/topojson/development/topojson.inc.js"})
   (minify    :in       "cljsjs/topojson/development/topojson.inc.js"
              :out      "cljsjs/topojson/production/topojson.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.topojson")))
