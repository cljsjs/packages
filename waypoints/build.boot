(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.1")
(def +version+ (str +lib-version+ "-0"))

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
   (download :url (format "https://github.com/imakewebthings/waypoints/archive/%s.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^waypoints-\d+\.\d+\.\d+/lib/noframework\.waypoints\.js$"
                "cljsjs/waypoints/development/waypoints.inc.js"
                #"^waypoints-\d+\.\d+\.\d+/lib/noframework\.waypoints\.min.js$"
                "cljsjs/waypoints/production/waypoints.min.inc.js"})
   (deps-cljs :foreign-libs [{:file #"waypoints\.inc\.js"
                              :file-min #"waypoints\.min\.inc\.js"
                              :provides ["waypoints" "cljsjs.waypoints"]
                              :global-exports '{waypoints Waypoint
                                                cljsjs.waypoints Waypoint}}]
              :externs [#"waypoints\.ext\.js"])
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
   (pom)
   (jar)
   (validate)))
