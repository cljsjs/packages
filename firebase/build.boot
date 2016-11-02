(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.5.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/firebase
       :version     +version+
       :description "Javascript client for Firebase.com"
       :url         "https://www.firebase.com/docs/web/api/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Firebase ToS" "https://www.firebase.com/terms/terms-of-service.html"}})

(deftask package []
  (comp
   (download :url (str "http://registry.npmjs.org/firebase/-/firebase-" +lib-version+ ".tgz")
             :checksum "9CC47991C5E481594EA360738FD709B4"
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"firebase_npm/firebase.js" "cljsjs/development/firebase.inc.js"
                #"firebase_npm/firebase-node.js" "cljsjs/development/firebase-node.inc.js"
                #"firebase_npm/externs/" "cljsjs/common/"}
         :include #{#"^cljsjs"
                    #"^deps.cljs"})
   (pom)
   (jar)))
