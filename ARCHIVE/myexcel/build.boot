(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/filesaverjs "1.3.3-0"]
                 [cljsjs/jszip "3.1.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/myexcel
      :version +version+
      :description "Create xlsx files"
      :url "http://github.com/jsgarra1971/MyExcel"
      :scm {:url "https://github.com/jsgarra1971/MyExcel"}
      :license {"MIT" "http://opensource.org/licenses/MIT"}})

(def github
  "https://raw.githubusercontent.com/jsegarra1971/MyExcel/28fc14719b620ac55a645243698c5a71c224fa83/")

(deftask package []
  (comp
   (download :url (str github "myexcel.js"))
   (sift :move {#"^myexcel.js"
                "cljsjs/myexcel/development/myexcel.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/myexcel/development/myexcel.inc.js"
           :out "cljsjs/myexcel/production/myexcel.min.inc.js")
   (deps-cljs :name "cljsjs.myexcel"
              :requires ["cljsjs.jszip" "cljsjs.filesaverjs"])
   (pom)
   (jar)
   (validate)))
