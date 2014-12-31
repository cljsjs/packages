(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "1.8.2-0")

(task-options!
  pom  {:project     'cljsjs/jquery
        :version     +version+
        :description "The Write Less, Do More, JavaScript Library."
        :url         "http://jquery.com/"
        :license     {:name "MIT" :url "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})
