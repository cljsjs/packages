(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.18")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/google-maps
       :version     +version+
       :description "Google Maps Javascript API"
       :url         "https://developers.google.com/maps/documentation/javascript/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Google Maps ToS" "https://www.google.com/intl/en_us/help/terms_maps.html"}})

