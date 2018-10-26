(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

; The version is from closure-compiler where the extern is from
(def +lib-version+ "v20170708")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/kakao
       :version     +version+
       :description "Kakao Javascript API"
       :url         "https://developers.kakao.com/docs/js-reference"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (pom)
    (jar)))
