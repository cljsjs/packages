(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.11.3-0")

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
    (download :url      "https://github.com/rwillig/jquery-ui/blob/master/resources/download/jquery-ui-1.11.3.zip?raw="
              :name     "jquery-ui-1.11.3.zip"
              :checksum "cb943ac26be9ee755e8741ea232389e2"
              :unzip    true)
    (sift :move {#"^jquery-ui-(.*)/([a-zA-Z-]+).js"       "cljsjs/development/$2.inc.js"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).min.js"   "cljsjs/production/$2.min.inc.js"
                 #"jquery-ui-(.*)/([a-zA-Z-\.]+).min.css"   "cljsjs/production/$2.min.inc.css"
                 #"jquery-ui-(.*)/([a-zA-Z-\.]+).css"       "cljsjs/development/$2.inc.css"
                 #"jquery-ui-(.*)/images/(.*\.png)$"      "cljsjs/common/images/$2"
                 })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery-ui")))
