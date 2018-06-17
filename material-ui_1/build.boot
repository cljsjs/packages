(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                  [cljsjs/react "16.4.0-0"]
                  [cljsjs/react-dom "16.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/material-ui
       :version     +version+
       :description "A Set of React Components that Implement Google's Material Design"
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-ui.inc.js"               "cljsjs/material-ui/development/material-ui.inc.js"
                #".*material-ui.min.inc.js"           "cljsjs/material-ui/production/material-ui.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"material-ui.inc.js"
                              :file-min #"material-ui.min.inc.js"
                              :provides ["material-ui"]
                              :global-exports '{material-ui MaterialUI}
                              ;; FIXME: Closure bug currently prevents using real npm name
                              ; :provides ["@material-ui/core"]
                              ; :global-exports '{@material-ui/core MaterialUI}
                              :requires ["react" "react-dom"]}]
              :externs [#"material-ui.ext.js"])
   (pom)
   (jar)
   (validate)))
