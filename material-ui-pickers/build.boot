(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.3-0"]
                 [cljsjs/material-ui "4.5.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/material-ui-pickers
      :version     +version+
      :description "Date & Time pickers, built with heart for @material-ui/core"
      :url         "http://material-ui-pickers.dev"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-ui-pickers.inc.js"     "cljsjs/material-ui-pickers/development/material-ui-pickers.inc.js"
                #".*material-ui-pickers.min.inc.js" "cljsjs/material-ui-pickers/production/material-ui-pickers.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"material-ui-pickers.inc.js"
                              :file-min #"material-ui-pickers.min.inc.js"
                              :provides ["@material-ui/pickers"
                                         "material-ui-pickers"
                                         "cljsjs.material-ui-pickers"]
                              :global-exports '{;; new names
                                                "@material-ui/pickers" MaterialUIPickers}
                              :requires ["react" "react-dom" "cljsjs.material-ui"]}]
              :externs [#"material-ui-pickers.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
