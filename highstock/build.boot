(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.14")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/highstock
       :version     +version+
       :description "Highstock lets you create stock or general timeline charts in pure JavaScript."
       :url         "http://highcharts.com/products/highstock"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.js")
             :checksum "4F6711DD693160FF8E0A9FB26008C661")
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.src.js")
             :checksum "002EF59E050D2ED3E7686497901B4A51")
   (sift :move {#"highstock.js"     "cljsjs/production/highstock.min.inc.js"})
   (sift :move {#"highstock.src.js" "cljsjs/development/highstock.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highstock")
   (pom)
   (jar)))
