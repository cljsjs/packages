(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.1.1-1")

(task-options!
 pom  {:project     'cljsjs/ol3
       :version     +version+
       :description "Openlayers v3 packaged up with Google Closure externs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/openlayers/ol3/releases/download/v3.1.1/v3.1.1.zip"
              :checksum "B0C8AEFACA19505A71C8E5002A2E5E26"
              :unzip true)
    (sift :move {#"v([\d\.]*)/build/ol.js" "cljsjs/development/ol3.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.ol3")))
