(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def codemirror-version "5.1.0")
(def +version+ (str codemirror-version "-0"))

(task-options!
  pom  {:project     'cljsjs/codemirror
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "Javascript syntax highlighter https://codemirror.net/"
        :url         "https://codemirror.net/"
        :license     {"MIT" "https://github.com/codemirror/CodeMirror/blob/master/LICENSE"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string]
         '[boot.util :refer [sh]]
         '[boot.tmpdir :as tmpd])

(deftask package []
  (comp
    (download :url (format "https://github.com/codemirror/CodeMirror/archive/%s.zip" codemirror-version)
              :unzip true
              :checksum "5471f9d6dca57a60721e2913ca6a3d96")
    (sift :move {#"^CodeMirror-([\d\.]*)/lib/codemirror\.js"      "cljsjs/codemirror/development/codemirror.inc.js"
                 #"^CodeMirror-([\d\.]*)/lib/codemirror\.css"     "cljsjs/codemirror/development/codemirror.css"})
    (minify    :in       "cljsjs/codemirror/development/codemirror.inc.js"
               :out      "cljsjs/codemirror/production/codemirror.min.inc.js")
    (minify    :in       "cljsjs/codemirror/development/codemirror.css"
               :out      "cljsjs/codemirror/production/codemirror.min.css")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.codemirror")))

