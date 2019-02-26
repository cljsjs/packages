(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.7")
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
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.js"))
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.src.js"))
   (sift :move {#"highstock.js"     "cljsjs/highstock/production/highstock.min.inc.js"})
   (sift :move {#"highstock.src.js" "cljsjs/highstock/development/highstock.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highstock")
   (pom)
   (jar)
   (validate)))
