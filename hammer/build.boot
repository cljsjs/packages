(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]])

(require '[adzerk.bootlaces   :refer :all])

(def +version+ "2.0.4")

(task-options!
 pom  {:project     'cljsjs/hammer
       :version     +version+
       :description "Hammer.js packaged up with Google Closure externs"
       :url         "http://hammerjs.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {:name "MIT"
                     :url  "http://opensource.org/licenses/MIT"}})
