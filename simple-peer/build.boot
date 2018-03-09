(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "8.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/simple-peer
      :version     +version+
      :description "Simple WebRTC video/voice and data channels."
      :url         "https://github.com/feross/simple-peer"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/simple-peer@%s/simplepeer.min.js" +lib-version+)
             :target "cljsjs/simple-peer/development/simple-peer.inc.js")

   (download :url (format "https://unpkg.com/simple-peer@%s/simplepeer.min.js" +lib-version+)
             :target "cljsjs/simple-peer/production/simple-peer.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.simple-peer")
   (pom)
   (jar)
   (validate-checksums)))
