(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery    "1.11.3-0"]
                  [cljsjs/moment    "2.10.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.9-0")

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
