(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.1-0")

(task-options!
 pom  {:project     'cljsjs/heap
       :version     +version+
       :description "Heap  js ext lib"
       :url         "https://heapanalytics.com/docs/custom-api"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Heap  ToS" "https://heapanalytics.com/terms"}})

