(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/openlayers "6.14.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.2.28")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/openlayers-ol-ext
       :version     +version+
       :description "ol-ext is a set of extensions, controls, interactions, popup to use with Openlayers."
       :url         "https://viglino.github.io/ol-ext/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download
    :url (format "https://cdn.jsdelivr.net/gh/Viglino/ol-ext@%s/dist/ol-ext.min.js" +lib-version+)
    :target "cljsjs/openlayers-ol-ext/production/openlayers-ol-ext.min.inc.js")
   (download
    :url (format "https://cdn.jsdelivr.net/gh/Viglino/ol-ext@%s/dist/ol-ext.js" +lib-version+)
    :target "cljsjs/openlayers-ol-ext/development/openlayers-ol-ext.inc.js")
   (download
    :url (format "https://cdn.jsdelivr.net/gh/Viglino/ol-ext@%s/dist/ol-ext.min.css" +lib-version+)
    :target "cljsjs/openlayers-ol-ext/common/openlayers-ol-ext.inc.css") 
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.openlayers-ol-ext"
              :requires ["cljsjs.openlayers"])
   (pom)
   (jar)
   (validate)))
