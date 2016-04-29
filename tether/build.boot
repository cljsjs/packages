(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/tether
       :version     +version+
       :description "A positioning engine to make overlays, tooltips and dropdowns better #hubspot-open-source"
       :url         "http://github.hubspot.com/tether"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (str "https://github.com/HubSpot/tether/archive/v" +lib-version+ ".zip")
	      :checksum "87C8DEC00FD6D9690449EA3A08DC1FA7"	
              :unzip true)

    (sift :move {#"^tether.*[/ \\]dist[/ \\]js[/ \\]tether.js$" "cljsjs/tether/development/tether.inc.js"
	         #"^tether.*[/ \\]dist[/ \\]js[/ \\]tether.min\.js$" "cljsjs/tether/production/tether.min.inc.js"
	         #"^tether.*[/ \\]dist[/ \\]css[/ \\]tether.css$" "cljsjs/tether/common/tether.inc.css"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.tether")
    (pom)
    (jar)))
