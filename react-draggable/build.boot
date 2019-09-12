(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                 [cljsjs/react "16.8.3-0"]
                 [cljsjs/react-dom "16.8.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.3")
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

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/react-draggable@" +lib-version+ "/web/react-draggable.min.js"))
   (sift :move {#"^react-draggable.min.js$" "cljsjs/react-draggable/development/react-draggable.inc.js"})
   (download :url (str "https://unpkg.com/react-draggable@" +lib-version+ "/web/react-draggable.min.js"))
   (sift :move {#"^react-draggable.min.js$" "cljsjs/react-draggable/production/react-draggable.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-draggable"
              :requires ["cljsjs.react" "cljsjs.react.dom"])
   (validate-checksums)
   (pom)
   (jar)))
