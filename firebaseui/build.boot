(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/firebase "5.7.3-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/firebaseui
       :version     +version+
       :description "FirebaseUI for Web"
       :url         "https://github.com/firebase/firebaseui-web"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str "http://registry.npmjs.org/firebaseui/-/firebaseui-" +lib-version+ ".tgz")
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"package/dist/firebaseui.js" "cljsjs/firebaseui/common/firebaseui.inc.js"
                #"package/dist/firebaseui.css" "cljsjs/firebaseui/common/firebaseui.inc.css"
                #"package/dist/externs/firebaseui-externs.js" "cljsjs/firebaseui/common/firebaseui-externs.ext.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.firebaseui")
   (pom)
   (jar)
   (validate)))
