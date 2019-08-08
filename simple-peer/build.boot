(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.0.0")
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
    (download
      :url (str "https://github.com/feross/simple-peer/archive/v" +lib-version+ ".zip")
      :unzip true)
    (sift :move {#".*simplepeer.min.js" "cljsjs/simple-peer/development/simple-peer.inc.js"
                 #".*simplepeer.min.js" "cljsjs/simple-peer/production/simple-peer.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.simple-peer")
    (pom)
    (jar)))
