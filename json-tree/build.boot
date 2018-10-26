(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.0")
(def +version+ (str +lib-version+ "-0"))
(def +json-tree-lib-path+ (str "jsonTreeViewer-" +lib-version+ "/libs/jsonTree/"))

(task-options!
 pom  {:project     'cljsjs/json-tree
       :version     +version+
       :description "JSON Tree Library which is a part of jsonTreeViewer"
       :url         "https://github.com/summerstyle/jsonTreeViewer/tree/master/libs/jsonTree"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/summerstyle/jsonTreeViewer/archive/" +lib-version+ ".zip")
             :unzip true)
   (sift :move {(re-pattern (str +json-tree-lib-path+ "jsonTree\\.js$")) "cljsjs/json-tree/development/json-tree.inc.js"
                (re-pattern (str +json-tree-lib-path+ "jsonTree\\.css$")) "cljsjs/json-tree/development/json-tree.inc.css"
                (re-pattern (str +json-tree-lib-path+ "icons\\.svg$")) "cljsjs/json-tree/development/icons.svg"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.json-tree")
   (pom)
   (jar)))
