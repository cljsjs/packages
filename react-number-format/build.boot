(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "v2.0.0-alpha2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-number-format
       :version     +version+
       :description "Yet another react component for input masking"
       :url         "https://github.com/s-yadav/react-number-format"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url (format "https://github.com/s-yadav/react-number-format/archive/%s.zip" +lib-version+)

     :unzip true)

   (sift :move {#"^react-number-format-.*[/ \\]dist[/ \\]react-number-format.js$" "cljsjs/react-number-format/development/react-number-format.inc.js"
                #"^react-number-format-.*[/ \\]dist[/ \\]react-number-format.min.js$" "cljsjs/react-number-format/production/react-number-format.min.inc.js"})
   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-number-format"
              :requires ["cljsjs.react"
                         "cljsjs.classnames"])
   (pom)
   (jar)))
