(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.11.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/hls
       :version     +version+
       :description "hls.js is a JavaScript library which implements an HTTP Live Streaming "
       :url         "https://github.com/video-dev/hls.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "https://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/hls.js@%s/dist/hls.js" +lib-version+)
              :target "cljsjs/hls/development/hls.inc.js")
    (download :url (format "https://unpkg.com/hls.js@%s/dist/hls.min.js" +lib-version+)
              :target "cljsjs/hls/development/hls.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hls")
    (pom)
    (jar)))
