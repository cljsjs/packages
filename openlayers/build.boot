(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.4.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/openlayers
       :version     +version+
       :description "A high-performance, feature-packed library for all your mapping needs"
       :url         "http://openlayers.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/openlayers/openlayers/releases/download/v%s/v%s.zip" +lib-version+ +lib-version+)
              :checksum "555FEADA2D0767132E278AE030BF3694"
              :unzip true)
    (download :url (format "https://github.com/openlayers/openlayers/archive/v%s.zip" +lib-version+)
              :checksum "89636AA3D173B338F59ADAD9DCD9C0F4"
              :unzip true)
    (sift :move {#"^v([\d\.]*)/ol/ol/" "cljsjs/openlayers/development/ol/"
                 #"^v([\d\.]*)/ol\.ext/" "cljsjs/openlayers/development/ol.ext/"
                 #"^v([\d\.]*)/css/ol\.css" "cljsjs/openlayers/common/openlayers.inc.css"
                 #"^openlayers-([\d\.]*)/externs/(.*)\.js" "cljsjs/openlayers/common/$2.ext.js"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})
    (pom)
    (jar)))
