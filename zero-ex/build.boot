(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.21.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/zero-ex
       :version     +version+
       :description "A JavaScript library for interacting with the 0x protocol"
       :url         "https://github.com/0xProject/0x.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/0xProject/0x.js/releases/download/v" +lib-version+ "/index.js"))    
    (download :url (str "https://github.com/0xProject/0x.js/releases/download/v" +lib-version+ "/index.min.js"))    
    (sift :move {#"index.js" "cljsjs/zero-ex/development/0x.inc.js"
                 #"index.min.js" "cljsjs/zero-ex/production/0x.min.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.zero-ex")
    (pom)
    (jar)))
