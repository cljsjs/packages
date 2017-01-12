(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0-pre.1")
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
             :checksum "856BD02AA2061CA6ACD2BDE8A5B52DC0")
   (sift :move {#"feathers.js" "cljsjs/feathers/development/feathers.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.feathers")
   (pom)
   (jar)))
