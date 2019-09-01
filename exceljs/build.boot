(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.15.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/exceljs
      :version     +version+
      :description "Excel Workbook Manager"
      :url         "https://github.com/exceljs/exceljs"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*exceljs.inc.js"     "cljsjs/exceljs/development/exceljs.inc.js"
                #".*exceljs.min.inc.js" "cljsjs/exceljs/production/exceljs.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"exceljs.inc.js"
                              :file-min #"exceljs.min.inc.js"
                              :provides ["exceljs"]
                              :global-exports '{exceljs EXCELJS}}]
              :externs [#"exceljs.ext.js"])
   (pom)
   (jar)
   (validate)))
