(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                 [cljsjs/react "15.4.0-0"]
                 [cljsjs/react-dom "15.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.5")

(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-modal
       :version     +version+
       :description "Accessible modal dialog component for React."
       :url         "https://reactjs.github.io/react-modal"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-react-modal []
  (download :url (format "https://github.com/reactjs/react-modal/archive/v%s.zip" +lib-version+)
            :checksum "6e1d66c3bb5bb349d58eef673b7da825"
            :unzip true))

(deftask package []
  (comp
   
   (download-react-modal)
   
   (sift :move {#"^react-modal-.*/dist/react-modal.js" "cljsjs/react-modal/development/react-modal.inc.js"})
   
   (sift :move {#"^react-modal-.*/dist/react-modal.min.js" "cljsjs/react-modal/production/react-modal.min.inc.js"})
   
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-modal"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)))
