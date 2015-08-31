(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def highcharts-version "4.1.8")
(def cljsjs-version "-0")
(def +version+ (str highcharts-version cljsjs-version))
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/highcharts
       :version     +version+
       :description "Create interactive charts easily for your web projects."
       :url         "http://highcharts.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url      (str "http://code.highcharts.com/" highcharts-version "/highcharts.js")
             :checksum "236BEAA96DBC1413D5D467E418CBFEA8")
   (download :url      (str "http://code.highcharts.com/" highcharts-version "/highcharts.src.js")
             :checksum "41195C3B6190A9344C5E1EF9F21BDF2F")
   (sift :move {#"highcharts.js"     "cljsjs/production/highcharts.min.inc.js"})
   (sift :move {#"highcharts.src.js"     "cljsjs/development/highcharts.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.highcharts"
              :requires ["cljsjs.jquery"])))
