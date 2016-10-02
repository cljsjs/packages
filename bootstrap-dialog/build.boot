(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery    "1.9.1-0"] ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.34.6-0")

(task-options!
  pom  {:project     'cljsjs/bootstrap-dialog
        :version     +version+
        :description "Javascript and CSS for Bootstrap Dialog"
        :url         "https://nakupanda.github.io/bootstrap3-dialog/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/nakupanda/bootstrap3-dialog"}})

(deftask package []
  (deps-cljs :name "cljsjs.bootstrap-dialog"
             :requires ["cljsjs.bootstrap"]))
