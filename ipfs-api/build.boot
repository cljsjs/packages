(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "18.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/ipfs-api
       :version     +version+
       :description "IPFS JavaScript API"
       :url         "https://github.com/ipfs/js-ipfs-api"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"LGPL" "http://opensource.org/licenses/LGPL-3.0"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/ipfs-api@" +lib-version+ "/dist/index.min.js"))
   (download :url (str "https://unpkg.com/ipfs-api@" +lib-version+ "/dist/index.js"))
   (sift :move {#"index.js" "cljsjs/development/ipfs.inc.js"
                #"index.min.js" "cljsjs/production/ipfs.min.inc.js"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (pom)
   (jar)))
