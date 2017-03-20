(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/optiscroll
        :version     +version+
        :description (str "Optiscroll is a tiny (9kb) and highly optimized "
                          "custom scrollbar library for modern web apps.")
        :url         "https://github.com/albertogasparin/Optiscroll"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/albertogasparin/Optiscroll"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/albertogasparin/Optiscroll/archive/v" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#"^Optiscroll-.*/dist/optiscroll.js" "cljsjs/development/optiscroll.inc.js"})
    (minify :in "cljsjs/development/optiscroll.inc.js" :out "cljsjs/production/optiscroll.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.optiscroll")
    (pom)
    (jar)))
