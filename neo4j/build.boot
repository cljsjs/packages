(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.7.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/neo4j
      :version     +version+
      :description "Neo4j Bolt driver for JavaScript"
      :url         "https://github.com/neo4j/neo4j-javascript-driver"
      :scm         {:url "https://github.com/neo4j/neo4j-javascript-driver"}
      :license     {"Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/neo4j-driver@" +lib-version+ "/lib/browser/neo4j-web.min.js"))
   (sift :move {#".*neo4j-web.min.js" "cljsjs/neo4j/development/neo4j-web.inc.js"})
   (download :url (str "https://unpkg.com/neo4j-driver@" +lib-version+ "/lib/browser/neo4j-web.min.js"))
   (sift :move {#".*neo4j-web.min.js" "cljsjs/neo4j/production/neo4j-web.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.neo4j")
   (pom)
   (jar)))
