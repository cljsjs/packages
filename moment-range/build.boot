(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/moment "2.17.1-1"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/moment-range
        :version     +version+
        :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
        :url         "https://github.com/rotaready/moment-range"
        :license     {"UNLICENSED" "http://unlicense.org/"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
 (comp
  (download :url (format (str "https://unpkg.com/moment-range@" +lib-version+ "/dist/moment-range.js"))
            :checksum "cc80196f80d987574caa23a0a8c0e1be"
            :unzip false)
   (sift :move {#"^moment-range.js" "cljsjs/moment-range/development/moment-range.inc.js"
                #"^moment-range.js" "cljsjs/moment-range/production/moment-range.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.moment-range"
              :requires #{"cljsjs.moment"})
   (pom)
   (jar)))
