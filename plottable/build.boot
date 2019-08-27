(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/plottable
      :version     +version+
      :description "Flexible, interactive charts for the web."
      :url         "http://plottablejs.org"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/palantir/plottable/archive/v" +lib-version+ ".zip")
             :checksum "e15e72ad7ba9ef3e1462b8be5750f929"
             :unzip true)
   (sift :move {#"plottable-\d+\.\d+\.\d+/plottable.js"     "cljsjs/plottable/development/plottable.inc.js"
                #"plottable-\d+\.\d+\.\d+/plottable.min.js" "cljsjs/plottable/production/plottable.min.inc.js"
                #"plottable-\d+\.\d+\.\d+/plottable.css"    "cljsjs/plottable/common/plottable.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.plottable"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
