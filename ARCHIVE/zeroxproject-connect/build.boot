(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljs-web3 "0.19.0-0-10"]
                 [cljsjs/bignumber "4.1.0-0"]
                 [cljsjs/crypto-js "3.1.9-1-0"]
                 [cljsjs/iconv-lite "0.4.18-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.6.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/zeroxproject-connect
      :version     +version+
      :description "Library that makes it easy to interact with Relayers that conform to the Standard Relayer API"
      :url         "https://0xproject.com/"
      :scm         {:url "https://github.com/0xProject/0x-monorepo/tree/development/packages/connect"}})

(defn get-file [fileset file-name]
  (io/file
   (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
   file-name))

(deftask build-connect []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-connect)
   (sift :move {#".*connect.js" "cljsjs/0xproject-connect/development/connect.inc.js"
                #".*connect.min.js" "cljsjs/0xproject-connect/production/connect.min.inc.js"
                #".*connect.ext.js" "cljsjs/0xproject-connect/common/connect.ext.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.zeroxproject-connect"
              :requires ["cljsjs.web3" "cljsjs.bignumber" "cljsjs.crypto-js", "cljsjs.iconv-lite"])
   (pom)
   (jar)))
