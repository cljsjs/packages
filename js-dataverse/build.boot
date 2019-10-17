(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                 [cljsjs/axios "0.19.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.17")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/js-dataverse
      :version     +version+
      :description "A Dataverse client for JavaScript and TypeScript"
      :url         "https://github.com/js-dataverse/js-dataverse"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*js-dataverse.inc.js"     "cljsjs/js-dataverse/development/js-dataverse.inc.js"
                #".*js-dataverse.min.inc.js" "cljsjs/js-dataverse/production/js-dataverse.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"js-dataverse.inc.js"
                              :file-min #"js-dataverse.min.inc.js"
                              :provides ["js-dataverse" "cljsjs.js-dataverse"]
                              :global-exports '{"js-dataverse" JsDataverse}
                              :requires ["cljsjs.axios"]}]
              :externs [#"js-dataverse.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
