(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                  [cljsjs/react "16.3.0-1"]
                  [cljsjs/react-dom "16.3.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0-beta.34")
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
                            ["npm" "run" "build:dev-icons"]
                            ["npm" "run" "build:prod"]
                            ["npm" "run" "build:prod-icons"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-ui.inc.js"               "cljsjs/material-ui/development/material-ui.inc.js"
                #".*material-ui-svg-icons.inc.js"     "cljsjs/material-ui/development/material-ui-svg-icons.inc.js"
                #".*material-ui.min.inc.js"           "cljsjs/material-ui/production/material-ui.min.inc.js"
                #".*material-ui-svg-icons.min.inc.js" "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"material-ui.inc.js"
                              :file-min #"material-ui.min.inc.js"
                              :provides ["material-ui" "cljsjs.material-ui"]
                              :global-exports '{material-ui MaterialUI
                                                material-ui/styles MaterialUIStyles}
                              :requires ["react" "react-dom"]}
                             {:file #"material-ui-svg-icons.inc.js"
                              :file-min #"material-ui-svg-icons.min.inc.js"
                              :provides ["material-ui-icons" "cljsjs.material-ui-svg-icons"]
                              :global-exports '{material-ui-icons MaterialUISvgIcons}
                              :requires ["material-ui"]}]
              :externs [#"material-ui.ext.js"
                        #"material-ui-svg-icons.ext.js"])
   (pom)
   (jar)
   (validate)))
