(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/apollo-fetch
        :version     +version+
        :description "Simple Graphql Client"
        :url         "https://github.com/apollographql/apollo-fetch"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://gitlab.com/offcourse/apollo-fetch-cdn-bundle/raw/" +lib-version+ "/dist/apollo-fetch-cdn-bundle.js"))
   (sift :move {#"^apollo-fetch-cdn-bundle.js$"  "cljsjs/apollo-fetch/common/apollo-fetch.inc.js"})
   (deps-cljs :foreign-libs [{:file #"apollo-fetch\.inc\.js"
                              :global-exports '{cljsjs/apollo-fetch apolloFetch}
                              :provides ["cljsjs.apollo-fetch"]}]
              :externs [#"apollo-fetch\.ext\.js"])
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
   (pom)
   (jar)
   (validate)))
