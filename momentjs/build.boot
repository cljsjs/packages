(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "2.6.0-0")

(task-options!
  pom  {:project     'cljsjs/momentjs
        :version     +version+
        :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
        :url         "http://momentjs.com/"
        :license     {:name "MIT" :url "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})
