(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery    "2.1.4-0"]
                  [cljsjs/jquery-ui "1.11.3-1"] ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "5.0.0-0")

(task-options!
  pom  {:project     'cljsjs/jqgrid
        :version     +version+
        :description "jqGrid plugin for jQuery"
        :url         "http://www.trirand.com/blog"
        :license     {"Multiple" "http://www.trirand.com/blog/?page_id=400"}
        :scm         {:url "https://github.com/tonytomov/jqGrid"}})

(deftask package []
  (deps-cljs :name "cljsjs.jqgrid"
             :requires ["cljsjs.jquery" "cljsjs.jquery-ui"]))
