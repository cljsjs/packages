(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/iota
      :version     +version+
      :description "IOTA Javascript Library"
      :url         "https://dev.iota.org"
      :scm         {:url "https://github.com/iotaledger/iota.lib.js"}
      :license     {"MIT License" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/iotaledger/iota.lib.js/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^iota.lib.js-[^/]*/dist/iota.js"     "cljsjs/iota/development/iota.inc.js"
                #"^iota.lib.js-[^/]*/dist/iota.min.js" "cljsjs/iota/production/iota.min.inc.js"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (deps-cljs :name "cljsjs.iota")
   (pom)
   (jar)))
