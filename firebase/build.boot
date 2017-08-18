(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.0")
(def +version+ (str +lib-version+ "-0"))
(def +checksum+ "549bae42c4d5ea59ef31b0d0e541fdc7")

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
             :checksum +checksum+
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"package/firebase.js" "cljsjs/development/firebase.inc.js"
                #"package/firebase-node.js" "cljsjs/development/firebase-node.inc.js"
                #"package/externs/" "cljsjs/common/"}
         :include #{#"^cljsjs"
                    #"^deps.cljs"})
   (pom)
   (jar)))
