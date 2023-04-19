(def +lib-version+ "4.2.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/screenfull
       :version     +version+
       :description "Simple wrapper for cross-browser usage of the JavaScript Fullscreen API, which lets you bring the page or any element into fullscreen. Smoothens out the browser implementation differences, so you don't have to."
       :url         "https://github.com/sindresorhus/screenfull.js"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/screenfull@" +lib-version+ "/dist/screenfull.js"))

    (sift :move {#"^screenfull.js$" "cljsjs/screenfull/development/screenfull.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.screenfull")
    (pom)
    (jar)
    (validate)))
