(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                 [cljsjs/react "15.4.0-0"]
                 [cljsjs/react-dom "15.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.2")

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
            :checksum "f91e3506bb45f918e557e9f66f8100e1"
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
