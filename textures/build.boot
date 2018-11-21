(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/d3 "4.12.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/textures
       :version     +version+
       :description "A JavaScript library for adding svg patterns to d3 visualizations"
       :url         "http://riccardoscalco.github.io/textures/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download
    :url (format "https://github.com/riccardoscalco/textures/archive/v%s.zip" +lib-version+)
    :unzip true)
   (sift :move {#"^textures.*/dist/textures\.js" "cljsjs/textures/development/textures.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify
    :in "cljsjs/textures/development/textures.inc.js"
    :out "cljsjs/textures/production/textures.min.inc.js"
    :lang :ecmascript5)
   (deps-cljs :name "cljsjs.textures"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)
   (validate)))
