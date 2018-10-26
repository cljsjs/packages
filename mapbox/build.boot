(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.46.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom {:project     'cljsjs/mapbox
      :version     +version+
      :description "Interactive, thoroughly customizable maps in the browser, powered by vector tiles and WebGL https://www.mapbox.com/maps"
      :url         "https://github.com/mapbox/mapbox-gl-js"
      :license     {"BSD-3-Clause" "https://raw.githubusercontent.com/mapbox/mapbox-gl-js/master/LICENSE.txt"}
      :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/mapbox-gl/"
              +lib-version+
              "/mapbox-gl-dev.js")
    :name "mapbox-gl-dev.inc.js"
    :unzip false)
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/mapbox-gl/"
              +lib-version+
              "/mapbox-gl.js")
    :name "mapbox-gl.inc.js"
    :unzip false)
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/mapbox-gl/"
              +lib-version+
              "/mapbox-gl.css")
    :name "mapbox-gl-dev.inc.css"
    :unzip false)
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/mapbox-gl/"
              +lib-version+
              "/mapbox-gl.css")
    :name "mapbox-gl.inc.css"
    :unzip false)
   (sift
    :move {#"^mapbox-gl-dev.inc.js$"  "cljsjs/mapbox/development/mapbox-gl-dev.inc.js"
           #"^mapbox-gl.inc.js$"      "cljsjs/mapbox/production/mapbox-gl.inc.js"
           #"^mapbox-gl-dev.inc.css$" "cljsjs/mapbox/development/mapbox-gl-dev.inc.css"
           #"^mapbox-gl.inc.css$"     "cljsjs/mapbox/production/mapbox-gl.inc.css"})
   (sift :include #{#"cljsjs"})
   (deps-cljs
    :name "cljsjs.mapbox")
   (pom)
   (jar)
   (validate-checksums)))
