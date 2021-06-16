(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "4.9.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/tabulator
       :version     +version+
       :description "An easy to use interactive table generation JavaScript library"
       :url         "http://tabulator.info/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/olifolkerd/tabulator/archive/" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#".*tabulator.js" "cljsjs/tabulator/development/tabulator.inc.js"
                #".*tabulator.css*" "cljsjs/tabulator/development/tabulator.inc.css"
                #".*tabulator.min.js" "cljsjs/tabulator/production/tabulator.min.inc.js"
                #".*tabulator.min.css" "cljsjs/tabulator/production/tabulator.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.tabulator")
   (pom)
   (jar)
   (validate-checksums)))
