(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.2")
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
   (download :url      (str "http://code.highcharts.com/stock/" +lib-version+ "/highstock.js")
             :checksum "D3E8F95E1D92704E5B160C1759F1D662")
   (download :url      (str "http://code.highcharts.com/stock/" +lib-version+ "/highstock.src.js")
             :checksum "D955A1BA26D7D9B9204B10D4F72C2D23")
   (sift :move {#"highstock.js"     "cljsjs/production/highstock.min.inc.js"})
   (sift :move {#"highstock.src.js"     "cljsjs/development/highstock.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highstock"
              :requires ["cljsjs.jquery"])))
