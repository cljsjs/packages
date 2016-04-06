(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[boot.task.built-in :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pusher
       :version     +version+
       :description "Pusher"
       :url         "https://github.com/pusher/pusher-js"
       :scm         {:url "https://github.com/pusher/pusher-js"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "http://js.pusher.com/3.0/pusher.js")
    (download :url "http://js.pusher.com/3.0/pusher.min.js")
    (sift :move {#"^pusher\.js" "cljsjs/pusher/development/pusher.inc.js"
                 #"^pusher\.min\.js" "cljsjs/pusher/production/pusher.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pusher")
    (pom)
    (jar)))
