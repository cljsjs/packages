(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery    "1.8.2-2"]
                  [cljsjs/moment    "2.6.0-3"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.5-2")

(task-options!
  pom  {:project     'cljsjs/jquery-daterange-picker
        :version     +version+
        :description "A jQuery plugin that allows user to select a date range."
        :url         "https://github.com/longbill/jquery-date-range-picker"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (deps-cljs :name "cljsjs.jquery-daterange-picker"
             :requires ["cljsjs.moment" "cljsjs.jquery"]))
