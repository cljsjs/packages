(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                 [cljsjs/jquery "1.11.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.2")
(def +version+ (str +lib-version+ "-2"))

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
             :checksum "59CCC9D7FB4D417D55124EB7C40975D9")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/highcharts.src.js")
             :checksum "FA3D4219B24F80A75170E8B3E5A564E1")
   (sift :move {#"highcharts.js"     "cljsjs/highcharts/production/highcharts.min.inc.js"})
   (sift :move {#"highcharts.src.js"     "cljsjs/highcharts/development/highcharts.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highcharts"
              :requires ["cljsjs.jquery"])))
