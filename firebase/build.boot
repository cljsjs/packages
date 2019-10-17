(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.1.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/firebase
       :version     +version+
       :description "Firebase Javascript SDK"
       :url         "https://firebase.google.com/docs/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://www.apache.org/licenses/LICENSE-2.0"
                     "Firebase ToS" "https://www.firebase.com/terms/terms-of-service.html"}})

(deftask package []
  (comp
   (download :url (str "http://registry.npmjs.org/firebase/-/firebase-" +lib-version+ ".tgz")
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"package/firebase([a-z\-]*).js" "cljsjs/development/firebase$1.inc.js"
                #"package/externs/" "cljsjs/common/"}
         :include #{#"^cljsjs"
                    #"^deps.cljs"})
   (pom)
   (jar)
   (validate)))
