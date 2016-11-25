(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.6")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/highcharts
       :version     +version+
       :description "Create interactive charts easily for your web projects."
       :url         "http://highcharts.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/highcharts.js")
             :checksum "c0fdddca1e1a865f0ffa20d76e45c1bb")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/highcharts.src.js")
             :checksum "65105e88fee7c23eb411e6460285e79f")
   (sift :move {#"highcharts.js"     "cljsjs/highcharts/production/highcharts.min.inc.js"})
   (sift :move {#"highcharts.src.js"     "cljsjs/highcharts/development/highcharts.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highcharts")
   (pom)
   (jar)))
