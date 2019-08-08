(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                 [cljsjs/react "16.8.3-0"]
                 [cljsjs/react-dom "16.8.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/material-ui
      :version     +version+
      :description "A Set of React Components that Implement Google's Material Design"
      :url         "http://www.material-ui.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-ui.inc.js"     "cljsjs/material-ui/development/material-ui.inc.js"
                #".*material-ui.min.inc.js" "cljsjs/material-ui/production/material-ui.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"material-ui.inc.js"
                              :file-min       #"material-ui.min.inc.js"
                              :provides       ["@material-ui/core"
                                               "@material-ui/core/styles"
                                               "@material-ui/core/colors"
                                         ;; old names
                                               "material-ui"
                                               "material-ui/styles"
                                               "material-ui/colors"
                                               "cljsjs.material-ui"]
                              :global-exports '{;; new names
                                                "@material-ui/core"        MaterialUI
                                                "@material-ui/core/styles" MaterialUIStyles
                                                "@material-ui/core/colors" MaterialUIColors
                                                ;; old names
                                                "material-ui/styles"       MaterialUIStyles
                                                "material-ui/colors"       MaterialUIColors
                                                "material-ui"              MaterialUI}
                              :requires       ["react" "react-dom"]}]
              :externs [#"material-ui.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
