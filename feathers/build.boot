(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/feathers
       :version     +version+
       :description "Javascript client for Feathersjs.com"
       :url         "http://feathersjs.com/"
       :scm         {:url "https://github.com/feathersjs/feathers"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/feathers-client@" +lib-version+ "/dist/feathers.js")
             :checksum "670A4BC77D59A2F98EED788CE770DEC1")
   (sift :move {#"feathers.js" "cljsjs/feathers/development/feathers.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.feathers")
   (pom)
   (jar)))
