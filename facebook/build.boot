(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

; The version is from closure-compiler where the extern is from
(def +lib-version+ "v20150729")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/facebook
       :version     +version+
       :description "Facebook Javascript API"
       :url         "https://developers.facebook.com/docs/javascript"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (pom)
    (jar)))
