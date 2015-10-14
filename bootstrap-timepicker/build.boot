(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery    "1.9.1-0"] ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.5.1-0")

(task-options!
  pom  {:project     'cljsjs/bootstrap-timepicker
        :version     +version+
        :description "A timepicker component for bootstrap"
        :url         "http://jdewit.github.io/bootstrap-timepicker/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (deps-cljs :name "cljsjs.bootstrap-timepicker"
             :requires ["cljsjs.jquery"]))
