(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.7.3")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/leaflet
       :version     +version+
       :description "JavaScript library for mobile-friendly interactive maps"
       :url         "http://leaflet.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Leaflet License" "https://github.com/Leaflet/Leaflet/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "http://leaflet-cdn.s3.amazonaws.com/build/leaflet-0.7.3.zip"
             :checksum "08A7F76F4B91DFACB07FEC70A8A1331A"
             :unzip true)
   (sift :move {#"leaflet\.js" "cljsjs/production/leaflet.inc.js"
                #"leaflet-src\.js" "cljsjs/development/leaflet-src.inc.js"
                #"leaflet\.css" "cljsjs/common/leaflet.inc.css"
                #"images" "cljsjs/common/images"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.leaflet")))
