(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "8.5.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/simple-peer
        :version     +version+
        :description "Simple WebRTC video/voice and data channels"
        :url         "https://github.com/feross/simple-peer"
        :license     {"MIT" "https://github.com/feross/simple-peer/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://wzrd.in/standalone/simple-peer@" +lib-version+))
    (sift :move {(re-pattern (str "^simple-peer@" +lib-version+)) "cljsjs/simple-peer/development/simple-peer.inc.js"})
    (minify :in "cljsjs/simple-peer/development/simple-peer.inc.js"
            :out "cljsjs/simple-peer/production/simple-peer.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.simple-peer")
    (pom)
    (jar)))
