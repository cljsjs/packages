(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]])

(require '[adzerk.bootlaces   :refer :all])

(def +version+ "0.12.2")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-with-addons
       :version     +version+
       :description "React.js packaged up with Google Closure externs"
       :url         "https://github.com/cljsjs/packages/tree/master/react-with-addons"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}})
