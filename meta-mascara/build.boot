(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/meta-mascara
       :version     +version+
       :description "An Ethereum keychain manager for Ethereum DAPPs.  This library provides Mascara, an alternative implementation of Metamask's keychain for browsers that don't have the Metamask Chrome extension installed."
       :url         "https://metamask.io/"
       :scm         {:url "https://github.com/MetaMask/mascara"}
       :license     {"MIT" "https://github.com/MetaMask/mascara/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "https://wallet.metamask.io/metamascara.js")
   (sift :move {#".*metamascara.js" "cljsjs/meta-mascara/common/meta-mascara.inc.js"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (pom)
   (jar)))
