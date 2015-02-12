(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.2.0-0")

(task-options!
 pom  {:project     'cljsjs/openlayers
       :version     +version+
       :description "Openlayers packaged up with Google Closure externs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/openlayers/ol3/releases/download/v3.2.0/v3.2.0.zip"
              :checksum "6245b6375de9415e0561d843b4ff1232"
              :unzip true)
    (sift :move {#"v([\d\.]*)/ol/ol/" "cljsjs/development/openlayers/ol/"
                 #"v([\d\.]*)/ol.ext/" "cljsjs/development/openlayers/ol.ext/"
                 #"v([\d\.]*)/css/ol.css" "cljsjs/common/openlayers.inc.css"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})))
