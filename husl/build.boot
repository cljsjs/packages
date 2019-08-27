(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/husl
        :version     +version+
        :description "Human-friendly HSL"
        :url         "http://www.husl-colors.org/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/husl-colors/husl/archive/v" +lib-version+ ".zip")
              :checksum "b19b7f2fe7fea5a1f37964cacbe3a5c4"
              :unzip true)
    (sift :move {(re-pattern (str "^husl-" +lib-version+ "/husl.js$")) "cljsjs/development/husl.inc.js"})
    (minify :in "cljsjs/development/husl.inc.js"
            :out "cljsjs/production/husl.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.husl")
    (pom)
    (jar)))
