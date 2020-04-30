(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.6-0"]
                 [cljsjs/material-ui "4.5.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.57.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/material-table
      :version     +version+
      :description "Material-table - A simple and powerful Datatable for React based on Material-UI Table with some additional features."
      :url         "http://www.material-table.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*material-table.inc.js"     "cljsjs/material-table/development/material-table.inc.js"
                #".*material-table.min.inc.js" "cljsjs/material-table/production/material-table.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"material-table.inc.js"
                              :file-min       #"material-table.min.inc.js"
                              :provides       ["material-table"
                                               "cljsjs.material-table"]
                              :global-exports '{;; new names
                                                "material-table" MaterialTable}
                              :requires       ["react" "react-dom" "cljsjs.material-ui"]}]
              :externs [#"material-table.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
