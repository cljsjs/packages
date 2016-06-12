(def +lib-version+ "0.12.4")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react "15.0.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-grid-layout
       :version     +version+
       :description "A draggable and resizable grid layout with responsive breakpoints, for React."
       :url         "https://github.com/STRML/react-grid-layout/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/STRML/react-grid-layout/archive/" +lib-version+ ".zip")
              :checksum "03f2bf66bba71a38011752e8ac027bdc"
              :unzip true)

    (sift :move {#"^react-grid-layout-(.*)/dist/react-grid-layout.min.js$" "cljsjs/react-grid-layout/development/react-grid-layout.inc.js"
                 #"^react-grid-layout-(.*)/css/styles.css$" "cljsjs/react-grid-layout/common/react-virtualized.inc.css"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-grid-layout"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
