(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.5")
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
             :checksum "A799EDB0B6147299905DC81F6B9A84F0")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/highcharts.src.js")
             :checksum "ABED63DF565BA70CD6E35B7160B69ECD")
   (sift :move {#"highcharts.js"     "cljsjs/highcharts/production/highcharts.min.inc.js"})
   (sift :move {#"highcharts.src.js"     "cljsjs/highcharts/development/highcharts.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highcharts")
   (pom)
   (jar)))
