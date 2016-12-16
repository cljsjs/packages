(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.4")
(def +version+ (str +lib-version+ "-0"))

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
             :checksum "004D5BCCF1DA5F16A2AFA638DDB802D5")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/highcharts.src.js")
             :checksum "F5D24B3045EE1C80A8A21930F6AE6FE3")
   (sift :move {#"highcharts.js"     "cljsjs/highcharts/production/highcharts.min.inc.js"})
   (sift :move {#"highcharts.src.js"     "cljsjs/highcharts/development/highcharts.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highcharts")
   (pom)
   (jar)))
