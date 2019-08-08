(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/tether
       :version     +version+
       :description "A positioning engine to make overlays, tooltips and dropdowns better #hubspot-open-source"
       :url         "http://tether.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/HubSpot/tether/archive/v" +lib-version+ ".zip")
              :checksum "A1A53FDD74FD4D8D1B41C10E85E9B456"
              :unzip true)

    (sift :move {#"^tether.*[/ \\]dist[/ \\]js[/ \\]tether.js$" "cljsjs/tether/development/tether.inc.js"
	         #"^tether.*[/ \\]dist[/ \\]js[/ \\]tether.min\.js$" "cljsjs/tether/production/tether.min.inc.js"
	         #"^tether.*[/ \\]dist[/ \\]css[/ \\]tether.css$" "cljsjs/tether/common/tether.inc.css"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.tether")
    (pom)
    (jar)))
