(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.8.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-grid-layout
       :version     +version+
       :description "A draggable and resizable grid layout with responsive breakpoints, for React."
       :url         "https://github.com/STRML/react-grid-layout/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (str "https://github.com/STRML/react-grid-layout/archive/" +lib-version+ ".zip")
	      :checksum "A052FED2986574E07BE4B1B643E0C80A"
	      :unzip true)

    (sift :move {#"^react-grid-layout.*[/ \\]dist[/ \\]react-grid-layout.min.js$" "cljsjs/react-input-autosize/development/react-grid-layout.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-grid-layout"
               :requires ["cljsjs.react"])))
