(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.8")
(def +version+ (str +lib-version+ "-0"))
(bootlaces! +version+)

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
             :checksum "361C3E0F78579289AA97D944FEB0B15B")
   (download :url      (str "http://code.highcharts.com/stock/" +lib-version+ "/highstock.src.js")
             :checksum "C225CFD33C03275C589F7F4B3A6D0C8D")
   (sift :move {#"highstock.js"     "cljsjs/production/highstock.min.inc.js"})
   (sift :move {#"highstock.src.js"     "cljsjs/development/highstock.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highstock"
              :requires ["cljsjs.jquery"])))
