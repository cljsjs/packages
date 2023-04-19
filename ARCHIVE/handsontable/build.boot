(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/handsontable
      :version     +version+
      :description "A pure JavaScript/HTML5 spreadsheet component with an Excel-like appearance"
      :url         "https://github.com/handsontable/handsontable"
      :scm         {:url "https://github.com/handsontable/handsontable"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/handsontable/handsontable/archive/%s.zip" +lib-version+)
              :checksum "5F39E79C96AD9F4EF7E47C9AF83F5B08"
              :unzip    true)
   (sift      :move     {#"^handsontable.*/dist/handsontable\.full\.js$"    "cljsjs/handsontable/development/handsontable.full.inc.js"
                         #"^handsontable.*/dist/handsontable\.full\.css$"   "cljsjs/handsontable/development/handsontable.full.css"

                         #"^handsontable.*/dist/handsontable\.full\.min\.js$"    "cljsjs/handsontable/production/handsontable.full.min.inc.js"
                         #"^handsontable.*/dist/handsontable\.full\.min\.css$"   "cljsjs/handsontable/production/handsontable.full.min.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.handsontable")
   (pom)
   (jar)))
