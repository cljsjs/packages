(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.3.0-0"]
                  [cljsjs/react-dom "15.3.0-0"]
                  [cljsjs/prop-types "15.5.10-1"]
                  [cljsjs/classnames "2.2.3-0"]
                  [cljsjs/react-input-autosize "2.0.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0-rc.10")
(def +version+ (str +lib-version+ "-1"))

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
   (download :url (str "https://github.com/JedWatson/react-select/archive/v" +lib-version+ ".zip")
             :checksum "2ccd33cb2fdde191b2d1f8d35da9128c"
             :unzip true)

   (sift :move {#"^react-select.*[/ \\]dist[/ \\]react-select.js$" "cljsjs/react-select/development/react-select.inc.js"
                #"^react-select.*[/ \\]dist[/ \\]react-select.min\.js$" "cljsjs/react-select/production/react-select.min.inc.js"
                #"^react-select.*[/ \\]dist[/ \\]react-select.css$" "cljsjs/react-select/common/react-select.inc.css"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-select"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"
                         "cljsjs.classnames"
                         "cljsjs.prop-types"
                         "cljsjs.react-input-autosize"])
   (pom)
   (jar)))
