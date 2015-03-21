(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/object-assign-shim
       :version     +version+
       :description "ES6 Object.assign method polyfill."
       :url         "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Public Domain" "http://creativecommons.org/publicdomain/zero/1.0/"}})

(deftask package []
  (deps-cljs :name "cljsjs.object-assign-shim"))
