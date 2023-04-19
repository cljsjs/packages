(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.13.1")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "graphql-js-%s" +lib-version+))

(task-options!
  pom {:project 'cljsjs/graphql
       :version +version+
       :description "The JavaScript reference implementation for GraphQL, a query language for APIs created by Facebook."
       :url "https://github.com/graphql/graphql-js"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(def webpack-file-name "webpack.config.js")

(defn get-file [fileset file-name]
      (io/file
        (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
        file-name))

(deftask build-graphql []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap fileset
                             (doseq [f (->> fileset boot/input-files)
                                     :let [target (io/file tmp (tmpd/path f))]]
                                    (io/make-parents target)
                                    (io/copy (tmpd/file f) target))
                             (io/copy (get-file fileset webpack-file-name)
                                      (io/file tmp +lib-folder+ webpack-file-name))
                             (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
                                      (do ((sh "npm" "install"))
                                          ((sh "npm" "install" "webpack"))
                                          ((sh "npm" "install" "webpack-cli"))
                                          ((sh "npm" "install" "babel-loader"))
                                          ((sh "npm" "install" "babel-preset-stage-0"))
                                          ((sh "./node_modules/.bin/webpack"))
                                          ((sh "./node_modules/.bin/webpack" "--env.production"))
                                          ((sh "rm" "-rf" "./node_modules"))))
                             (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download :url (format "https://github.com/graphql/graphql-js/archive/v%s.zip" +lib-version+)
                     :checksum "E60C376F979E72B9F80BA7C68516E1F9"
                     :unzip true)
           (build-graphql)
           (sift :move {#".*graphql.inc.js"
                        "cljsjs/graphql/development/graphql.inc.js"
                        #".*graphql.min.inc.js"
                        "cljsjs/graphql/production/graphql.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.graphql"
                      :global-exports '{cljsjs.graphql GraphQL})
           (pom)
           (jar)))
