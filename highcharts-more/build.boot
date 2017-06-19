(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.12")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                 [cljsjs/highcharts  "5.0.12-0" :scope "provided"]])

(task-options!
 pom  {:project     'cljsjs/highcharts-more
       :version     +version+
       :description "Create interactive charts easily for your web projects."
       :url         "http://highcharts.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url      (str "https://code.highcharts.com/" +lib-version+ "/highcharts-more.js")
             :checksum "dda9ab34720516d2cefc8a06ebb1a2bd")
   (download :url      (str "https://code.highcharts.com/" +lib-version+ "/highcharts-more.src.js")
             :checksum "8bef5b2c018f3fe29ffd6f6536567705")
   (sift :move {#"highcharts-more.js"     "cljsjs/highcharts/production/highcharts-more.min.inc.js"})
   (sift :move {#"highcharts-more.src.js"     "cljsjs/highcharts/development/highcharts-more.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highcharts-more")
   (pom)
   (jar)))
