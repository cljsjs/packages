(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react "0.14.3-0"]
                  [cljsjs/react-dom "0.14.3-0"]
                  [cljsjs/react-drag "0.2.7-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-reorderable
       :version     +version+
       :description "Simple react sortable component (for more advanced cases use react-dnd)."
       :url         "https://mgechev.github.io/react-reorderable/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/mgechev/react-reorderable/master/dist/react-reorderable.js"
	      :checksum "A3979D24AB1B53E3DF26626A03EC93C5")
    (sift :move {#"^react-reorderable.js$" "cljsjs/react-reorderable/development/react-reorderable.inc.js"})

    (download :url "https://raw.githubusercontent.com/mgechev/react-reorderable/master/dist/react-reorderable.min.js"
	      :checksum "B6D1793C4D848BCF5839968C86B4D17C")
    (sift :move {#"^react-reorderable.min.js$" "cljsjs/react-reorderable/production/react-reorderable.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-reorderable"
               :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.react-drag"])))
