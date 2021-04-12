(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "17.0.1-0"]
                 [cljsjs/react-dom "17.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-tagcloud
       :version     +version+
       :description "Simple and extensible tag/word cloud React component."
       :url         "https://github.com/madox2/react-tagcloud"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*react-tagcloud.inc.js"     "cljsjs/react-tagcloud/development/react-tagcloud.inc.js"
                #".*react-tagcloud.min.inc.js" "cljsjs/react-tagcloud/production/react-tagcloud.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"react-tagcloud.inc.js"
                              :file-min       #"react-tagcloud.min.inc.js"
                              :provides       ["react-tagcloud"
                                               "cljsjs.react-tagcloud"]
                              :global-exports '{"react-tagcloud"   ReactTagcloud}
                              :requires       ["react" "react-dom"]}]
              :externs [#"react-tagcloud.ext.js"])
   (pom)
   (jar)
   (validate)))
