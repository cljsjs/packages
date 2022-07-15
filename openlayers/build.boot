(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.14.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/openlayers
       :version     +version+
       :description "A high-performance, feature-packed library for all your mapping needs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
   (download
    :url (format "https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v%s/build/ol.min.js" +lib-version+)
    :target "cljsjs/openlayers/production/openlayers.min.inc.js")
   (download
    :url (format "https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v%s/build/ol.js" +lib-version+)
    :target "cljsjs/openlayers/development/openlayers.inc.js")
   (download
    :url (format "https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v%s/css/ol.css" +lib-version+)
    :target "cljsjs/openlayers/common/openlayers.inc.css")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.openlayers")
   (pom)
   (jar)
   (validate)))
