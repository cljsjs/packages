(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.18-0")

(task-options!
 pom  {:project     'cljsjs/google-maps
       :version     +version+
       :description "Google Maps ext lib"
       :url         "https://developers.google.com/maps/documentation/javascript/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Google Maps ToS" "https://www.google.com/intl/en_us/help/terms_maps.html"}})

