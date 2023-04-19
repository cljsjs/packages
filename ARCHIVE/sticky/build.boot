(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/sticky
        :version     +version+
        :description "Sticky-js is a library for sticky elements written in vanilla javascript."
        :url         "https://github.com/rgalus/sticky-js"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/rgalus/sticky-js"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/rgalus/sticky-js/archive/" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#"^sticky-.*/dist/sticky.min.js" "cljsjs/development/sticky.inc.js"})
    (minify :in "cljsjs/development/sticky.inc.js" :out "cljsjs/production/sticky.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.sticky")
    (pom)
    (jar)))
