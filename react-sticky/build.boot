(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]
                  [cljsjs/react-dom "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-sticky
       :version     +version+
       :description "React component for creating fixed and sticky DOM elements."
       :url         "https://github.com/captivationsoftware/react-sticky"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-react-sticky []
  (download :url (format "https://github.com/captivationsoftware/react-sticky/archive/%s.zip" +lib-version+)
              :checksum "4d8ecec1e0bb9ee852ca118ec309db88"
              :unzip true))

(deftask package []
  (comp
    
    (download-react-sticky)

    (sift :move {#"^react-sticky-.*/dist/react-sticky.js" "cljsjs/react-sticky/development/react-sticky.inc.js"})

    (sift :move {#"^react-sticky-.*/dist/react-sticky.min.js" "cljsjs/react-sticky/production/react-sticky.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-sticky"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
