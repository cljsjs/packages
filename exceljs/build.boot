(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.8.0")
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
   (download
    :url (format "https://unpkg.com/exceljs@%s/dist/exceljs.js" +lib-version+)
    :target "cljsjs/exceljs/development/exceljs.inc.js")
   (download
    :url (format "https://unpkg.com/exceljs@%s/dist/exceljs.min.js" +lib-version+)
    :target "cljsjs/exceljs/production/exceljs.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"exceljs.inc.js"
                              :file-min #"exceljs.min.inc.js"
                              :provides ["exceljs" "cljsjs.exceljs"]
                              :global-exports '{"exceljs" ExcelJS}}]
              :externs [#"exceljs.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
