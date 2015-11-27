(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
		  [cljsjs/react "0.14.3-0"]
                  [cljsjs/classnames "2.1.3-0"]
                  [cljsjs/react-input-autosize "0.6.5-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0-beta5")
(def +version+ (str +lib-version+ "-0"))
(bootlaces! +version+)

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
    (download :url "https://raw.githubusercontent.com/JedWatson/react-select/master/dist/react-select.js")
    (download :url "https://raw.githubusercontent.com/JedWatson/react-select/master/dist/react-select.css")
    (sift :move {#"^react-select.js$" "cljsjs/react-select/development/react-select.inc.js"
                 #"^react-select.css$" "cljsjs/react-select/development/react-select.inc.css"})

    (download :url "https://raw.githubusercontent.com/JedWatson/react-select/master/dist/react-select.min.js")
    (download :url "https://raw.githubusercontent.com/JedWatson/react-select/master/dist/react-select.min.css")
    (sift :move {#"^react-select.min.js$" "cljsjs/react-select/production/react-select.min.inc.js"
                 #"^react-select.min.css$" "cljsjs/react-select/production/react-select.min.inc.css"})

    (sift :to-resource #{#".*.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-select"
               :requires ["cljsjs.react"
                          "cljsjs.classnames"
                          "cljsjs.react-input-autosize"])))
