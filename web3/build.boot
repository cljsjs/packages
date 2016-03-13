(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.15.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/web3
       :version     +version+
       :description "Ethereum JavaScript API"
       :url         "https://github.com/ethereum/web3.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"LGPL" "http://opensource.org/licenses/LGPL-3.0"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/ethereum/web3.js/archive/" +lib-version+ ".zip")
              :unzip true)    
    (sift :move {#"web3.js-0.15.3/dist/web3.js" "cljsjs/development/web3.inc.js"
                 #"web3.js-0.15.3/dist/web3.min.js" "cljsjs/production/web3.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.web3")
    (pom)
    (jar)))
