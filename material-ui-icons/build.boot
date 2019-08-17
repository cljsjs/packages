(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/react "16.8.6-0"]
                  [cljsjs/react-dom "16.8.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/material-ui-icons
       :version     +version+
       :description "Material Design Svg Icons converted to Material-UI React components."
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-ui-icons.inc.js"               "cljsjs/material-ui/development/material-ui-icons.inc.js"
                #".*material-ui-icons.min.inc.js"           "cljsjs/material-ui/production/material-ui-icons.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"material-ui-icons.inc.js"
                              :file-min #"material-ui-icons.min.inc.js"
                              :provides ["@material-ui/icons"
                                         ;; old names
                                         "material-ui-icons"]
                              :global-exports '{"@material-ui/icons" MaterialUIIcons
                                                ;; old names
                                                material-ui-icons MaterialUIIcons}
                              :requires ["react" "react-dom"]}]
              :externs [#"material-ui-icons.ext.js"])
   (pom)
   (jar)
   (validate)))
