(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.15.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/xlsx
      :version     +version+
      :description "SheetJS Spreadsheet data parser and writer"
      :url         "https://sheetjs.com/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*xlsx.inc.js"     "cljsjs/xlsx/development/xlsx.inc.js"
                #".*xlsx.min.inc.js" "cljsjs/xlsx/production/xlsx.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"xlsx.inc.js"
                              :file-min #"xlsx.min.inc.js"
                              :provides ["xlsx"]
                              :global-exports '{xlsx XLSX}}]
              :externs [#"xlsx.ext.js"])
   (pom)
   (jar)
   (validate)))
