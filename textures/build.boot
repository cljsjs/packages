(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.3")
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
    #_(download :url "https://github.com/riccardoscalco/textures/archive/master.zip"
              :checksum "84A1B1D175D8407C7B110DFDD40F537E" ;;sha1
              :unzip true)
    (download :url "https://raw.githubusercontent.com/riccardoscalco/textures/master/textures.js"
              :checksum "880132a6e85afa07a3001350d3b287ef")
    (sift :move {#"textures.js" "cljsjs/textures/development/textures.inc.js"
                 #_#"textures.min.js" #_"cljsjs/textures/production/textures.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.textures")
    (pom)
    (jar)))
