(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.3.0-0")

(task-options!
 pom  {:project     'cljsjs/openlayers
       :version     +version+
       :description "A high-performance, feature-packed library for all your mapping needs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/openlayers/ol3/releases/download/v3.3.0/v3.3.0.zip"
              :checksum "0d12356abb8e4ac6d3d3d955e1abbd47"
              :unzip true)
    (download :url "https://github.com/openlayers/ol3/archive/v3.3.0.zip"
              :checksum "cc552d354453d0ac7e1ae6fb849d9766"
              :unzip true)
    (sift :move {#"^v([\d\.]*)/ol/ol/" "cljsjs/development/openlayers/ol/"
                 #"^v([\d\.]*)/ol.ext/" "cljsjs/development/openlayers/ol.ext/"
                 #"^v([\d\.]*)/css/ol.css" "cljsjs/common/openlayers.inc.css"
                 #"^ol3-([\d\.]*)/externs/oli.js" "cljsjs/common/openlayersi.ext.js"
                 #"^ol3-([\d\.]*)/externs/olx.js" "cljsjs/common/openlayersx.ext.js"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})))
