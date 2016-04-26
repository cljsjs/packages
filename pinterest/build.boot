(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

; The version is from closure-compiler where the extern is from
(def +lib-version+ "v20160425")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pinterest
       :version     +version+
       :description "Pinterest Javascript API"
       :url         "https://developers.pinterest.com/docs/sdks/js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (pom)
    (jar)))
