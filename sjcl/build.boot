(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.0.6")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/sjcl
        :version     +version+
        :description "Stanford Javascript Crypto Library"
        :url         "https://github.com/bitwiseshiftleft/sjcl/blob/master/sjcl.js"
        :license     {"BSD" "https://opensource.org/licenses/BSD-3-Clause"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url (format "https://raw.githubusercontent.com/bitwiseshiftleft/sjcl/%s/sjcl.js" 
                          +lib-version+)
             :checksum "D7DC40AD6718245B6B5F158F621FC4E4"
             :unzip false)

   (sift :move {#"^sjcl.js" "cljsjs/sjcl/development/sjcl.inc.js"
                #"^sjcl.js" "cljsjs/sjcl/production/sjcl.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.sjcl")
   (pom)
   (jar)))
