(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/react "16.0.0-0" :scope "provided"]
                 [cljsjs/react-dom "16.0.0-0" :scope "provided"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[clojure.java.io :as io])

(def +lib-version+ "0.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/react-giphy-selector
      :version     +version+
      :description "A very customizable react search component for picking the perfect giphy."
      :url         "https://github.com/bago2k4/react-giphy-selector"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
  (download :url (format "https://github.com/bago2k4/react-giphy-selector/archive/v%s.zip" +lib-version+)
            :unzip true))

(deftask package []
  (comp
   (download-lib)
   (sift :move {#".*index.js" "cljsjs/react-giphy-selector/development/react-giphy-selector.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/react-giphy-selector/development/react-giphy-selector.inc.js"
           :out "cljsjs/react-giphy-selector/production/react-giphy-selector.min.inc.js")
   (deps-cljs :name "cljsjs.react-giphy-selector"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate-checksums)))
