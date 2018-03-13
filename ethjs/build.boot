(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/ethjs
       :version     +version+
       :description "A highly optimised, light-weight JS utility for Ethereum."
       :url         "https://github.com/ethjs/ethjs"
       :scm         {:url "https://github.com/ethjs/ethjs"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url "https://cdn.jsdelivr.net/npm/ethjs@0.3.0/dist/ethjs.js")
   (download :url "https://cdn.jsdelivr.net/npm/ethjs@0.3.0/dist/ethjs.min.js")
   (sift :move {#".*ethjs.js"        "cljsjs/ethjs/development/ethjs.js"
                #".*ethjs.min.js"    "cljsjs/ethjs/production/ethjs.min.js"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (pom)
   (jar)))
