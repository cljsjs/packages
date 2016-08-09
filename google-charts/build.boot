(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/google-charts
       :version     +version+
       :description "Google Charts Javascript API"
       :url         "https://developers.google.com/chart/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Google Maps ToS" "https://www.google.com/intl/en_us/help/terms_maps.html"}})

(deftask package []
  (comp
    (pom)
    (jar)))
