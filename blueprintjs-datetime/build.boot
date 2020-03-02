(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.6-0"]
                 [cljsjs/blueprintjs-core "3.22.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.15.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/blueprintjs-datetime
       :version     +version+
       :description "Blueprint is a React UI toolkit for the web."
       :url         "https://blueprintjs.com/docs/#datetime"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*blueprintjs-datetime.inc.js"     "cljsjs/blueprintjs-datetime/development/blueprintjs-datetime.inc.js"
                #".*blueprintjs-datetime.min.inc.js" "cljsjs/blueprintjs-datetime/production/blueprintjs-datetime.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"blueprintjs-datetime.inc.js"
                              :file-min       #"blueprintjs-datetime.min.inc.js"
                              :provides       ["blueprintjs-datetime"
                                               "cljsjs.blueprintjs-datetime"]
                              :global-exports '{"blueprintjs-datetime"   BlueprintJSDatetime}
                              :requires       ["react" "react-dom" "blueprintjs-core"]}]
              :externs [#"blueprintjs-datetime.ext.js"])
   (pom)
   (jar)
   (validate)))
