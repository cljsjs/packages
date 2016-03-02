(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.16")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/msgpack-lite
       :version     +version+
       :description "Fast pure JavaScript MessagePack encoder and decoder"
       :url         "https://github.com/kawanet/msgpack-lite"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/kawanet/msgpack-lite/archive/" +lib-version+ ".zip")
              :checksum "AECD02AABF1ADD8ED7771CD541980E84"
              :unzip true)
    (sift :move {#"^msgpack-lite-.*/dist/msgpack\.min\.js"     "cljsjs/msgpack-lite/development/msgpack-lite.inc.js"
                 #"^msgpack-lite-.*/dist/msgpack\.min\.js"     "cljsjs/msgpack-lite/production/msgpack-lite.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.msgpack-lite")))
