(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/dygraph
        :version     +version+
        :description "Dygraph Charting Library"
        :url         "http://dygraphs.com"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download  :url      (str "http://dygraphs.com/" +lib-version+ "/dygraph.min.js"))
   (download  :url      (str "http://dygraphs.com/" +lib-version+ "/dygraph.js"))
   (download  :url      (str "http://dygraphs.com/" +lib-version+ "/dygraph.css"))
   (sift      :move     {#"^dygraph.js"
                         "cljsjs/dygraph/development/dygraph.inc.js"
                         #"^dygraph.min.js"
                         "cljsjs/dygraph/production/dygraph.min.inc.js"
                         #"^dygraph.css"
                         "cljsjs/dygraph/common/dygraph.inc.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.dygraph")
   (pom)
   (jar)
   (validate-checksums)))

