(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.1.1-0")

(task-options!
 pom  {:project     'cljsjs/openlayers
       :version     +version+
       :description "Openlayers packaged up with Google Closure externs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

; NOTE: The externs was generated manually using a script in the upstream repo.  
; We hope this file may be included in future upstream releases.  A ticket has been
; raised in relation to this: https://github.com/openlayers/ol3/issues/3202

(deftask package []
  (comp
    (download :url "https://github.com/openlayers/ol3/releases/download/v3.1.1/v3.1.1.zip"
              :checksum "B0C8AEFACA19505A71C8E5002A2E5E26"
              :unzip true)
    (sift :move {#"v([\d\.]*)/build/ol.js" "cljsjs/development/openlayers.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.openlayers")))
