(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/react "15.4.2-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/graphiql
      :version +version+
      :description "An in-browser IDE for exploring GraphQL."
      :url "https://github.com/graphql/graphiql"
      :scm {:url "https://github.com/graphql/graphiql"}
      :license {"GraphiQL license" "https://github.com/graphql/graphiql/blob/master/LICENSE"}})

(defn download-url [version filename]
  (format "https://github.com/graphql/graphiql/releases/download/v%s/%s" version filename))

(defn graphiql-files [version]
  {:css {:url (download-url version "graphiql.css")
         :md5 "218ce5929a1c17269749b35e1c418d12"}
   :js {:url (download-url version "graphiql.js")
        :md5 "a04307ecb01ac84c90b95d57e9e692bf"}
   :js-min {:url (download-url version "graphiql.min.js")
            :md5 "720944a1de615400798306f8488d2878"}})

(defn download-files [version]
  (let [files (graphiql-files version)]
    (apply comp
      (for [{:keys [url md5]} (vals files)]
        (download :url url :checksum md5)))))

(deftask package []
  (comp (download-files +lib-version+)
        (sift :move {#"graphiql.js" "cljsjs/graphiql/development/graphiql.inc.js"
                     #"graphiql.min.js" "cljsjs/graphiql/production/graphiql.min.inc.js"
                     #"graphiql.css" "cljsjs/graphiql/common/graphiql.css"})
        (sift :include #{#"^cljsjs"}
              :to-resource #{#"cljsjs/graphiql/common/graphiql.css"})
        (deps-cljs :name "cljsjs.graphiql" :requires ["cljsjs.react"])
        (pom)
        (show :fileset true)
        (jar)))
