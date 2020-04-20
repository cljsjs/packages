(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.6-0"]
                 [cljsjs/material-ui "4.5.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.0-alpha.49")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/material-ui-lab
      :version     +version+
      :description "Material-UI Lab - Incubator for Material-UI React components."
      :url         "http://www.material-ui.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-ui-lab.inc.js"     "cljsjs/material-ui-lab/development/material-ui-lab.inc.js"
                #".*material-ui-lab.min.inc.js" "cljsjs/material-ui-lab/production/material-ui-lab.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"material-ui-lab.inc.js"
                              :file-min       #"material-ui-lab.min.inc.js"
                              :provides       ["@material-ui/lab"
                                               "material-ui-lab"
                                               "cljsjs.material-ui-lab"]
                              :global-exports '{;; new names
                                                "@material-ui/lab" MaterialUILab}
                              :requires       ["react" "react-dom" "cljsjs.material-ui"]}]
              :externs [#"material-ui-lab.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
