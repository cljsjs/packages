(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/iscroll
        :version     +version+
        :description "Smooth scrolling for the web"
        :url         "https://github.com/cubiq/iscroll"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cubiq/iscroll"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/cubiq/iscroll/archive/v" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#"^iscroll-.*/build/iscroll.js" "cljsjs/development/iscroll.inc.js"})
    (minify :in "cljsjs/development/iscroll.inc.js" :out "cljsjs/production/iscroll.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.iscroll")
    (pom)
    (jar)))
