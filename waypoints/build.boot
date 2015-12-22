(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.1.1-0")

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/waypoints
       :version     +version+
       :description "Waypoints is a library that makes it easy to execute a function whenever you scroll to an element."
       :url         "http://imakewebthings.com/waypoints/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url "https://github.com/imakewebthings/waypoints/archive/3.1.1.zip"
             :checksum "eca8f3548bdedf8444e7ef3af676bbad"
             :unzip true)
   (sift :move {#"^waypoints-\d+\.\d+\.\d+/lib/noframework\.waypoints\.js$"
                "cljsjs/waypoints/development/waypoints.inc.js"
                #"^waypoints-\d+\.\d+\.\d+/lib/noframework\.waypoints\.min.js$"
                "cljsjs/waypoints/production/waypoints.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.waypoints")))
