(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/firebase-node
       :version     +version+
       :description "Nodejs client for Firebase.com"
       :url         "https://www.firebase.com/docs/web/api/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Firebase ToS" "https://www.firebase.com/terms/terms-of-service.html"}})

(deftask package []
  (comp
    (download :url (str "https://cdn.firebase.com/js/client/" +lib-version+ "/firebase-node.js")
              :checksum "604D4138A35710D01CD10E9482C80E08")
    (sift :move {#"firebase-node.js" "cljsjs/development/firebase-node.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.firebase")
    (pom)
    (jar)))
