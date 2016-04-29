(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/moment "2.9.0-3"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/moment-range
        :version     +version+
        :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
        :url         "http://gf3.github.io/moment-range/"
        :license     {"UNLICENSED" "http://unlicense.org/"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (format "https://github.com/gf3/moment-range/archive/%s.zip" +lib-version+)
              :checksum "705f4467371c7c3a442d0dbc573fe073"
              :unzip true)

    (sift :move {#"^moment-range.*/dist/moment-range\.js"          "cljsjs/moment-range/development/moment-range.inc.js"
                 #"^moment-range.*/dist/moment-range\.min\.js"     "cljsjs/moment-range/production/moment-range.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.moment-range"
               :requires #{"cljsjs.moment"})
    (pom)
    (jar)))
