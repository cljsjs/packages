(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/object-assign-shim
       :version     +version+
       :description "ES6 Object.assign method polyfill."
       :url         "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Public Domain" "http://creativecommons.org/publicdomain/zero/1.0/"}})

(deftask package []
  (deps-cljs :name "cljsjs.object-assign-shim"))
