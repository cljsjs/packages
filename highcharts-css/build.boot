(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.10")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/highcharts-css
       :version     +version+
       :description "Create interactive charts easily for your web projects."
       :url         "http://highcharts.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/js/highcharts.js")
             :checksum "5528DF77753114ADD3EF9E1BAC2962EE")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/js/highcharts.src.js")
             :checksum "DAA1C5BA8E7DEC5AED35E7606CF63A34")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/css/highcharts.css")
             :checksum "018F28C9EDD947DD3211B01FD5D5C91C")
   (sift :move {#"highcharts.js"     "cljsjs/highcharts/production/highcharts.min.inc.js"
                #"highcharts.src.js" "cljsjs/highcharts/development/highcharts.inc.js"
                #"highcharts.css"    "cljsjs/highcharts/development/highcharts.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highcharts-css")
   (pom)
   (jar)))
