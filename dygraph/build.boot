(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
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
   (download  :url      (str "https://cdnjs.cloudflare.com/ajax/libs/dygraph/" +lib-version+ "/dygraph-combined-dev.js")
              :checksum "e1a5e2346cad6d3236921f9581922b3f")
   (download  :url      (str "https://cdnjs.cloudflare.com/ajax/libs/dygraph/" +lib-version+ "/dygraph-combined.js")
              :checksum "a6fc6e899b07c124d0a0c9b1cb3e9db4")
   (sift      :move     {#"^dygraph-combined-dev.js"
                         "cljsjs/dygraph/development/dygraph.inc.js"
                         #"^dygraph-combined.js"
                         "cljsjs/dygraph/production/dygraph.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.dygraph")
   (pom)
   (jar)))

