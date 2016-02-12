(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.18")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/topojson
       :version     +version+
       :description "An extension to GeoJSON that encodes topology"
       :url         "https://github.com/mbostock/topojson"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Bostock" "https://github.com/mbostock/topojson/blob/v1.6.18/LICENSE"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/mbostock/topojson/archive/v%s.zip" +lib-version+)
              :checksum "036a19607242e00de0222d103febd161"
              :unzip    true)
   (sift      :move     {#"^topojson-.*/topojson.js"
                         "cljsjs/topojson/development/topojson.inc.js"})
   (minify    :in       "cljsjs/topojson/development/topojson.inc.js"
              :out      "cljsjs/topojson/production/topojson.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.topojson")))
