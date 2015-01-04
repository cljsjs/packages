(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]
                  [cljsjs/jquery    "1.8.2-0"]
                  [cljsjs/momentjs  "2.6.0-0"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.0.5-0")

(task-options!
  pom  {:project     'cljsjs/jquery-daterange-picker
        :version     +version+
        :description "A jQuery plugin that allows user to select a date range."
        :url         "https://github.com/longbill/jquery-date-range-picker"
        :license     {:name "MIT" :url "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})
