(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.7.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.12")
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
             :checksum "5B251590C79F9B9887440FDE061E4444")
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.src.js")
             :checksum "57A40290D795AF0B8B88130F068AE623")
   (sift :move {#"highstock.js"     "cljsjs/production/highstock.min.inc.js"})
   (sift :move {#"highstock.src.js" "cljsjs/development/highstock.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highstock")
   (pom)
   (jar)))
