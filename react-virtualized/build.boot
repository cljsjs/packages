(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react "15.0.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-virtualized
       :version     +version+
       :description "React components for efficiently rendering large lists and tabular data."
       :url         "https://bvaughn.github.io/react-virtualized/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/bvaughn/react-virtualized/archive/" +lib-version+ ".zip")
             :checksum "744B96FAD492C3B7FAFCF966F8B4E8CB"
             :unzip true)

   (sift :move {#"^react-virtualized-(.*)/dist/umd/react-virtualized.js$" "cljsjs/react-virtualized/development/react-virtualized.inc.js"
                #"^react-virtualized-(.*)/source/styles.css$" "cljsjs/react-virtualized/common/react-virtualized.inc.css"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-virtualized"
              :requires ["cljsjs.react"])
   (pom)

   (jar)))
