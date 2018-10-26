(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]
                  [cljsjs/react-dom "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-draggable
       :version     +version+
       :description "React draggable component."
       :url         "https://github.com/mzabriskie/react-draggable"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-react-draggable []
  (download :url (format "https://github.com/mzabriskie/react-draggable/archive/v%s.zip" +lib-version+)
            :checksum "c3e5fcda8e216f431fa48263a04fc2c8"
            :unzip true))

(deftask package []
  (comp
    
    (download-react-draggable)

    (sift :move {#"^react-draggable-.*/dist/react-draggable.js" "cljsjs/react-draggable/development/react-draggable.inc.js"})

    (sift :move {#"^react-draggable-.*/dist/react-draggable.min.js" "cljsjs/react-draggable/production/react-draggable.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-draggable"
               :requires ["cljsjs.react" "cljsjs.react.dom"])
    (pom)
    (jar)))
