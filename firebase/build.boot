(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.9.0")
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
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"package/firebase.js" "cljsjs/development/firebase.inc.js" 
                #"package/firebase-firestore.js" "cljsjs/development/firebase-firestore.inc.js" 
                #"package/firebase-app.js" "cljsjs/development/firebase-app.inc.js" 
                #"package/firebase-auth.js" "cljsjs/development/firebase-auth.inc.js" 
                #"package/firebase-database.js" "cljsjs/development/firebase-database.inc.js" 
                #"package/firebase-messaging.js" "cljsjs/development/firebase-messageing.inc.js" 
                #"package/firebase-storage.js" "cljsjs/development/firebase-storage.inc.js" 
                #"package/externs/" "cljsjs/common/"}
         :include #{#"^cljsjs"
                    #"^deps.cljs"})
   (pom)
   (jar)
   (validate-checksums)))
