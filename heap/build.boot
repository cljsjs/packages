(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/heap
       :version     +version+
       :description "Javascript API for Heap analytics"
       :url         "https://heapanalytics.com/docs/custom-api"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Heap  ToS" "https://heapanalytics.com/terms"}})

