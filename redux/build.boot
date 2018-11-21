(set-env!
  :resource-paths #{"resources"}
  :dependencies   '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/redux
       :version +version+
       :description "Predictable state container for JavaScript apps"
       :url "https://github.com/reactjs/redux"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/redux@" +lib-version+ "/dist/redux.js"))
    (download :url (str "https://unpkg.com/redux@" +lib-version+ "/dist/redux.min.js"))
    (sift :move {#"^redux\.js" "cljsjs/redux/development/redux.inc.js"
                 #"^redux\.min\.js" "cljsjs/redux/production/redux.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.redux")
    (pom)
    (jar)
    (validate)))
