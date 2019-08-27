(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                 [cljsjs/d3 "5.7.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3-bipartite
       :version     +version+
       :description "A D3 layout for drawing weighted bipartite graphs"
       :url         "https://github.com/ilyabo/d3-bipartite"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/d3-bipartite@%s/dist/d3-bipartite.min.js"
                    +lib-version+))
   (download :url (format "https://unpkg.com/d3-bipartite@%s/dist/d3-bipartite.js"
                    +lib-version+))
   (sift :move {#"^d3-bipartite\.js"
                "cljsjs/d3-bipartite/development/d3-bipartite.inc.js"
                #"^d3-bipartite\.min\.js"
                "cljsjs/d3-bipartite/production/d3-bipartite.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-bipartite"
              :requires ["cljsjs.d3"])
   (validate)
   (pom)
   (jar)))
