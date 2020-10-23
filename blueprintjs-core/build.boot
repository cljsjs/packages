(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "16.13.1-0"]
                 [cljsjs/react-dom "16.13.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.34.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/blueprintjs-core
       :version     +version+
       :description "Blueprint is a React UI toolkit for the web."
       :url         "https://blueprintjs.com/docs/#core"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*blueprintjs-core.inc.js"     "cljsjs/blueprintjs-core/development/blueprintjs-core.inc.js"
                #".*blueprintjs-core.min.inc.js" "cljsjs/blueprintjs-core/production/blueprintjs-core.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"blueprintjs-core.inc.js"
                              :file-min       #"blueprintjs-core.min.inc.js"
                              :provides       ["blueprintjs"
                                               "blueprintjs-core"
                                               "blueprintjs-icons"
                                               "cljsjs.blueprintjs-core"]
                              :global-exports '{"blueprintjs"        BlueprintJS
                                                "blueprintjs-core"   BlueprintJS
                                                "blueprintjs-icons"  BlueprintJSIcons}
                              :requires       ["react" "react-dom"]}]
              :externs [#"blueprintjs-core.ext.js"])
   (pom)
   (jar)
   (validate)))
