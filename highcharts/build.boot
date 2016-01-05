(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                 [cljsjs/jquery "1.11.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.10")
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
             :checksum "d7c3fbca69de8db03d011f471aeaac19")
   (download :url      (str "http://code.highcharts.com/" +lib-version+ "/highcharts.src.js")
             :checksum "ba0df0dcf757b702387bb859d9a951bc")
   (sift :move {#"highcharts.js"     "cljsjs/production/highcharts.min.inc.js"})
   (sift :move {#"highcharts.src.js"     "cljsjs/development/highcharts.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highcharts"
              :requires ["cljsjs.jquery"])))
