(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/react "16.2.0-3"]
                 [cljsjs/react-dom "16.2.0-3"]
                 [cljsjs/prop-types "15.5.10-1"]
                 [cljsjs/classnames "2.2.3-0"]
                 [cljsjs/react-input-autosize "2.2.1-1"]
                 [cljsjs/emotion "10.0.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-select
       :version     +version+
       :description "A flexible and beautiful Select Input control for ReactJS with multiselect, autocomplete and ajax support."
       :url         "http://jedwatson.github.io/react-select/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url  (format "https://unpkg.com/react-select@%s/dist/react-select.js" +lib-version+))
   (download :url  (format "https://unpkg.com/react-select@%s/dist/react-select.min.js" +lib-version+))
   (sift :move {#"react-select.js" "cljsjs/development/react-select.inc.js"})
   (sift :move {#"react-select.min.js" "cljsjs/development/react-select.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-select"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"
                         "cljsjs.classnames"
                         "cljsjs.prop-types"
                         "cljsjs.react-input-autosize"
                         "cljsjs.emotion"])
   (pom)
   (jar)
   (validate-checksums)))
