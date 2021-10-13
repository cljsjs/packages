(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "17.0.1-0"]
                 [cljsjs/react-dom "17.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/react-d3-cloud
       :version     +version+
       :description "A word cloud react component built with d3-cloud."
       :url         "https://github.com/Yoctol/react-d3-cloud"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*react-d3-cloud.inc.js"     "cljsjs/react-d3-cloud/development/react-d3-cloud.inc.js"
                #".*react-d3-cloud.min.inc.js" "cljsjs/react-d3-cloud/production/react-d3-cloud.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"react-d3-cloud.inc.js"
                              :file-min       #"react-d3-cloud.min.inc.js"
                              :provides       ["react-d3-cloud"
                                               "cljsjs.react-d3-cloud"]
                              :global-exports '{"react-d3-cloud"   ReactD3-cloud}
                              :requires       ["react" "react-dom"]}]
              :externs [#"react-d3-cloud.ext.js"])
   (pom)
   (jar)
   (validate)))
