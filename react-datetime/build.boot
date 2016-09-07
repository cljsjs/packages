(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.3.0-0"]
                  [cljsjs/moment "2.10.6-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "2.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-datetime
       :version     +version+
       :description "A lightweight but complete datetime picker react component."
       :url         "https://github.com/YouCanBookMe/react-datetime"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-datepicker []
  (download :url (str "https://github.com/YouCanBookMe/react-datetime/archive/v" +lib-version+ ".zip")
            :checksum "8a4ad17109b8b44714500120406ba2e9"
            :unzip true))

(deftask package []
  (comp
    (download-datepicker)
    (sift :move {#"^react-datetime.*[/ \\]dist[/ \\]react-datetime.js$" "cljsjs/react-datetime/development/react-datetime.inc.js"
	         #"^react-datetime.*[/ \\]dist[/ \\]react-datetime.min\.js$" "cljsjs/react-datetime/production/react-datetime.min.inc.js"
	         #"^react-datetime.*[/ \\]css[/ \\]react-datetime.css$" "cljsjs/react-datetime/common/react-datetime.inc.css"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-datetime"
               :requires ["cljsjs.react"
                          "cljsjs.moment"])
    (pom)
    (jar)))
