(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.3")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/neo4j
      :version     +version+
      :description "Neo4j Bolt driver for JavaScript"
      :url         "https://github.com/neo4j/neo4j-javascript-driver"
      :scm         {:url "https://github.com/neo4j/neo4j-javascript-driver"}
      :license     {"Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/neo4j/neo4j-javascript-driver/archive/%s.zip" +lib-version+)
              :checksum "cf5b971dcee56f6cd1bcb4a0f14de23d"
              :unzip    true)
   (sift      :move     {#"^neo4j(.*)/lib/browser/neo4j-web.js"
                         "cljsjs/neo4j/development/neo4j.inc.js"
                         #"^neo4j(.*)/lib/browser/neo4j-web.min.js"
                         "cljsjs/neo4j/production/neo4j.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.neo4j")
   (pom)
   (jar)))
