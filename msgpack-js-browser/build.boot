(def +lib-version+ "0.1.4")
(def +version+ (str +lib-version+ "-1"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/msgpack-js-browser
       :version     +version+
       :description "A msgpack encoder and decoder using ArrayBuffer and DataView"
       :url         "https://github.com/creationix/msgpack-js-browser"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/creationix/msgpack-js-browser/archive/" +lib-version+ ".zip")
             :checksum "8c46e7b58908230f1d024d05661b2883"
             :unzip true)

   (sift :move {#"^msgpack-js-browser-(.*)/msgpack.js$"
                "cljsjs/msgpack-js-browser/development/msgpack.inc.js"})
   (minify :in  "cljsjs/msgpack-js-browser/development/msgpack.inc.js"
           :out "cljsjs/msgpack-js-browser/production/msgpack.min.inc.js"
           :lang :ecmascript5_strict)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.msgpack-js-browser")
   (pom)
   (jar)))
