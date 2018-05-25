(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.4")
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
   (sift :move {#"package/firebase-([a-z\-]*).js" "cljsjs/development/firebase-$1.inc.js"
                #"package/firebase=([a-z\-]*).js.map" "cljsjs/development/firebase-$1.inc.js.map"
                #"package/externs/" "cljsjs/common/"}
         :include #{#"^cljsjs"
                    #"^deps.cljs"})
   (pom)
   (jar)
   (validate-checksums)))
