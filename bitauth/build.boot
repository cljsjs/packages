(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +version+ "0.2.3")
;; TODO: Stop using xcthulhu's branch when BitPay merges unicode support
;;(def +cljsjs-version+ (str +version+ "-0"))
(def +cljsjs-version+ (str +version+ "-xcthulhu"))
(bootlaces! +cljsjs-version+)

(task-options!
 pom  {:project     'cljsjs/bitauth
       :version     +cljsjs-version+
       :description "Authenticate with web services utilizing the same strategy as Bitcoin"
       :url         "https://github.com/bitpay/bitauth"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    ;; TODO: Stop using xcthulhu's branch when BitPay merges unicode support
    ;;:url (format "https://github.com/bitpay/bitauth/archive/v%s.zip" +version+)
    :url (format "https://github.com/xcthulhu/bitauth/archive/v%s.zip" +version+)
    :checksum "793ECDC5B87FC237F5E7B38B271379D9"
    :unzip true)
   (sift :move {#".*dist/bitauth\.bundle\.js"       "cljsjs/bitauth/development/bitauth.inc.js"
                #".*dist/bitauth\.browser\.min\.js" "cljsjs/bitauth/production/bitauth.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.bitauth")))
