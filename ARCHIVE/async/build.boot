(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0-rc.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/async
       :version     +version+
       :description "Higher-order functions and common patterns for asynchronous code"
       :url         "https://github.com/caolan/async"
       :license     {"License" "https://raw.githubusercontent.com/caolan/async/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/caolan/async/archive/v%s.zip" +lib-version+)
             :checksum "c6cbd5d1b655f3412d38005b1b67415e"
             :unzip true)
   (sift :move {#"^async-.*/dist/async.js$" "cljsjs/development/async.inc.js"})
   (minify :in "cljsjs/development/async.inc.js" :out "cljsjs/production/async.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.async")
   (pom)
   (jar)))
