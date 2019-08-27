(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/iota-mam
      :version     +version+
      :description "IOTA MAM Javascript Library"
      :url         "https://dev.iota.org"
      :scm         {:url "https://github.com/iotaledger/mam.client.js"}
      :license     {"MIT License" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/iotaledger/mam.client.js/archive/master.zip")
             :unzip true)
   (sift :move {#"^mam.client.js-master/lib/mam.web.js"                    "cljsjs/iota/development/mam.web.inc.js"
                #"^mam.client.js-master/lib/iota-bindings-emscripten.wasm" "cljsjs/iota/development/iota-bindings-emscripten.wasm"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (deps-cljs :name "cljsjs.iota-mam")
   (pom)
   (jar)))
