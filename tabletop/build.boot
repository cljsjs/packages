(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/tabletop
      :version     +version+
      :description "Tabletop.js takes a Google Spreadsheet and makes it easily accessible through JavaScript."
      :url         "https://github.com/jsoma/tabletop"
      :scm         {:url "https://github.com/jsoma/tabletop"}
      :license     {"MIT" "https://github.com/jsoma/tabletop/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/jsoma/tabletop/archive/v%s.zip" +lib-version+)
             :checksum "78712A719EDCBBE05DC9450A93666F44"
              :unzip true)
   (sift :move {#"^tabletop-.*/src/tabletop\.js$"      "cljsjs/tabletop/development/tabletop.inc.js"})
   (minify :in  "cljsjs/tabletop/development/tabletop.inc.js"
           :out "cljsjs/tabletop/production/tabletop.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.tabletop")
   (pom)
   (jar)))
