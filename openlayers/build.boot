(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.8" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.5.0-0")

(task-options!
 pom  {:project     'cljsjs/openlayers
       :version     +version+
       :description "A high-performance, feature-packed library for all your mapping needs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/openlayers/ol3/releases/download/v3.5.0/v3.5.0.zip"
              :checksum "7A2A23F1ACFCBE9E5CC9EF0F710FE937"
              :unzip true)
    (download :url "https://github.com/openlayers/ol3/archive/v3.5.0.zip"
              :checksum "02CB2E53BF9E29A78A3FE0F008B05563"
              :unzip true)
    (sift :move {#"^v([\d\.]*)/ol/ol/" "cljsjs/openlayers/development/ol/"
                 #"^v([\d\.]*)/ol\.ext/" "cljsjs/openlayers/development/ol.ext/"
                 #"^v([\d\.]*)/css/ol\.css" "cljsjs/openlayers/common/openlayers.inc.css"
                 #"^ol3-([\d\.]*)/externs/(.*)\.js" "cljsjs/openlayers/common/$2.ext.js"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})))
