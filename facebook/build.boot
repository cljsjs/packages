(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

; The version is from closure-compiler where the extern is from
(def +version+ "v20150729-0")

(task-options!
 pom  {:project     'cljsjs/facebook
       :version     +version+
       :description "Facebook Javascript API"
       :url         "https://developers.facebook.com/docs/javascript"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

