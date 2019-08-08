(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/feathers
       :version     +version+
       :description "Javascript client for Feathersjs.com"
       :url         "http://feathersjs.com/"
       :scm         {:url "https://github.com/feathersjs/client"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/feathersjs/client/archive/v" +lib-version+ ".zip")
             :decompress true)
   (sift :move {#"client-.*/dist/feathers\.js" "cljsjs/feathers/development/feathers.inc.js"
                #"client-.*/dist/feathers\.min\.js" "cljsjs/feathers/production/feathers.min.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.feathers")
   (pom)
   (jar)
   (validate)))
