(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.28.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/date-fns
        :version     +version+
        :description "Modern JavaScript date utility library"
        :url         "https://github.com/date-fns/date-fns"
        :license     {"MIT" "https://kossnocorp.mit-license.org"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*/date-fns.inc.js"  "cljsjs/date-fns/development/date-fns.inc.js"
                #".*/date-fns.min.inc.js"  "cljsjs/date-fns/production/date-fns.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"date-fns.inc.js"
                              :file-min       #"date-fns.min.inc.js"
                              :provides       ["date-fns" "cljsjs.date-fns"]
                              :global-exports '{"date-fns" dateFns}}]
              :externs [#"date-fns.ext.js"])
   (pom)
   (jar)
   (validate)))
