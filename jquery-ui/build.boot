(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery "1.9.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.11.3")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/jquery-ui
       :version     +version+
       :description "jQuery UI is a curated set of user interface interactions, effects, widgets, and themes"
       :url         "http://jqueryui.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    ; FIXME: Should use upstream source
    (download :url      (format "https://github.com/rwillig/jquery-ui/blob/master/resources/download/jquery-ui-%s.zip?raw=" +lib-version+)
              :name     (format "jquery-ui-%s.zip" +lib-version+)
              :checksum "cb943ac26be9ee755e8741ea232389e2"
              :unzip    true)
    (sift :include #{#"^jquery-ui-(.*)/external/(.*).js"} :invert true)
    (sift :move {#"^jquery-ui-(.*)/([a-zA-Z-]+).js"                 "cljsjs/development/$2.inc.js"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).min.js"             "cljsjs/production/$2.min.inc.js"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).min.css"            "cljsjs/common/css/$2.min.inc.css"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).theme.min.css"      "cljsjs/common/css/$2.theme.min.inc.css"
                 #"^jquery-ui-(.*)/([a-zA-Z-]+).structure.min.css"  "cljsjs/common/css/$2.structure.min.inc.css"
                 #"^jquery-ui-(.*)/images/(.*\.png)$"               "cljsjs/common/images/$2"
                 })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery-ui"
               :requires ["cljsjs.jquery"])))
