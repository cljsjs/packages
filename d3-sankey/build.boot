(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/d3 "6.2.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.12.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3-sankey
       :version     +version+
       :description "Sankey diagrams visualize the directed flow between nodes in an acyclic network"
       :url         "https://github.com/d3/d3-sankey"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/d3-sankey@%s/dist/d3-sankey.min.js"
                    +lib-version+))
   (download :url (format "https://unpkg.com/d3-sankey@%s/dist/d3-sankey.js"
                    +lib-version+))
   (sift
     :move {#"^d3-sankey\.js"
            "cljsjs/d3-sankey/development/d3-sankey.inc.js"
            #"^d3-sankey\.min\.js"
            "cljsjs/d3-sankey/production/d3-sankey.min.inc.js"}
     :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-sankey"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)
   (validate-checksums)))
