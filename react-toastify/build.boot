(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "17.0.2-0"]
                 [cljsjs/react-dom "17.0.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/react-toastify
      :version     +version+
      :description "React notification made easy."
      :url         "https://github.com/fkhadra/react-toastify"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*react-toastify.inc.js"     "cljsjs/react-toastify/development/react-toastify.inc.js"
                #".*react-toastify.min.inc.js" "cljsjs/react-toastify/production/react-toastify.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"react-toastify.inc.js"
                              :file-min #"react-toastify.min.inc.js"
                              :provides ["cljsjs.react-toastify"]
                              :global-exports '{"react-toastify" ReactToastify}
                              :requires       ["react" "react-dom"]}]
              :externs [#"react-toastify.ext.js"])
   (pom)
   (jar)
   (validate)))
