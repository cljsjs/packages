(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "17.0.1-0"]
                  [cljsjs/react-dom "17.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.6.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/re-resizable
       :version     +version+
       :description "A resizable component for React."
       :url         "https://github.com/bokuweb/re-resizable"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*re-resizable.inc.js"     "cljsjs/re-resizable/development/re-resizable.inc.js"
                #".*re-resizable.min.inc.js" "cljsjs/re-resizable/production/re-resizable.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.re-resizable")
   (deps-cljs :foreign-libs [{:file #"re-resizable.inc.js"
                              :file-min #"re-resizable.min.inc.js"
                              :provides ["cljsjs.re-resizable"]
                              :global-exports '{"re-resizable" ReResizable}
                              :requires       ["react" "react-dom"]}]
              :externs [#"re-resizable.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
