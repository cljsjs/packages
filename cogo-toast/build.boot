(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/cogo-toast
       :version     +version+
       :description "Beautiful, Zero Configuration, Toast Messages for React"
       :url         "https://github.com/Cogoport/cogo-toast"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*cogo-toast.inc.js"     "cljsjs/cogo-toast/development/cogo-toast.inc.js"
                #".*cogo-toast.min.inc.js" "cljsjs/cogo-toast/production/cogo-toast.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.cogo-toast")
   (deps-cljs :foreign-libs [{:file #"cogo-toast.inc.js"
                              :file-min #"cogo-toast.min.inc.js"
                              :provides ["cljsjs.cogo-toast"]
                              :global-exports '{"cogo-toast" CogoToast}}]
              :externs [#"cogo-toast.ext.js"])
   (pom)
   (jar)
   (validate)))
