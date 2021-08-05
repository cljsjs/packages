(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "17.0.1-0"]
                 [cljsjs/react-dom "17.0.1-0"]
                 [cljsjs/leaflet "1.7.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-leaflet
       :version     +version+
       :description "JavaScript Library for Mobile-Friendly Interactive Maps"
       :url         "https://github.com/PaulLeCam/react-leaflet"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*react-leaflet.inc.js"     "cljsjs/react-leaflet/development/react-leaflet.inc.js"
                #".*react-leaflet.min.inc.js" "cljsjs/react-leaflet/production/react-leaflet.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["react-leaflet" "cljsjs.react-leaflet" "@react-leaflet/core"]
              :requires ["leaflet" "react" "react-dom"]
              :global-exports '{react-leaflet ReactLeaflet
                                "@react-leaflet/core" ReactLeafletCore})
   (pom)
   (jar)
   (validate)))
