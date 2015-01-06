(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.12.2-2")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "React.js packaged up with Google Closure externs"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {:name "BSD"
                     :url  "http://opensource.org/licenses/BSD-3-Clause"}})
