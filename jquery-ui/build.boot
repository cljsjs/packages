(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]
                  [cljsjs/jquery "2.1.1-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.11.4-0")

(task-options!
 pom  {:project     'cljsjs/jquery-ui
       :version     +version+
       :description "jQuery-ui packaged with google closure externs"
       :url         "http://jqueryui.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      "https://raw.githubusercontent.com/ZabelTech/jquery-ui/master/jquery-ui-1.11.4.zip"
              :name     "jquery-ui-1.11.4.zip"
              :checksum "C578DE5FEAECA4190EF89E00519E91DC"
              :unzip    true)
    (sift :move {#"^jquery-ui-(.*)/([a-zA-Z-]+).js"                 "cljsjs/development/$2.inc.js"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).min.js"             "cljsjs/production/$2.min.inc.js"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).min.css"            "cljsjs/common/css/$2.min.inc.css"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).theme.min.css"      "cljsjs/common/css/$2.theme.min.inc.css"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).structure.min.css"  "cljsjs/common/css/$2.structure.min.inc.css"
                 #"^jquery-ui-(.*)/images/(.*\.png)$"               "cljsjs/common/images/$2"
                 })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery-ui"
               :requires ["cljsjs.jquery" "cljsjs.jquery-ui"])))
