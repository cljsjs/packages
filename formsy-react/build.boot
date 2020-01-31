(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "15.2.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.19.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/formsy-react
       :version     +version+
       :description "A form input builder and validator for React JS."
       :url         "https://github.com/christianalfoni/formsy-react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-formsy-react []
  (download :url      (format "https://github.com/christianalfoni/formsy-react/archive/v%s.zip" +lib-version+)
            :checksum "6f68e7d02296294f0a72c14f0edc51c5" ;;MD5
            :unzip    true))

(deftask package []
  (comp
    (download-formsy-react)
    (sift :move {#"^formsy-react.*/release/formsy-react.js"
                 "cljsjs/formsy-react/development/formsy-react.inc.js"
                 #"^formsy-react-.*/release/formsy-react.js"
                 "cljsjs/formsy-react/production/formsy-react.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.formsy-react"
               :requires ["cljsjs.react.dom"])
    (pom)
    (jar)))
