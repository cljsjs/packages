(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.5")
(def +version+ (str +lib-version+ "-0"))

(def unpkg-dist-url (str "https://unpkg.com/alasql@" +lib-version+ "/dist"))

(task-options!
  pom  {:project     'cljsjs/alasql
        :version     +version+
        :description "AlaSQL is a lightweight client-side in-memory SQL database designed to work in browser and Node.js."
        :url         "https://github.com/agershun/alasql"
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str unpkg-dist-url "/alasql.js"))
    (download :url (str unpkg-dist-url "/alasql.min.js"))

    (sift :move {#"alasql.js" "cljsjs/alasql/development/alasql.inc.js"
                 #"alasql.min.js" "cljsjs/alasql/production/alasql.min.inc.js"}
          :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.alasql")
    (pom)
    (jar)
    (validate)))
