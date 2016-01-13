(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[boot.core :as c]
         '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[clojure.java.io :as io])

(def +version+ "0.3")

(task-options!
 pom {:project 'cljsjs/incremental-dom
      :version +version+
      :description "Dom-building library from google"
      :url "http://github.com/google/incremental-dom"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache 2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
   (c/with-pass-thru fileset (dosh "make" "work/incremental-dom/dist/incremental-dom-closure-provides.js"
                                   (str "TAG=" +version+)))
   (c/with-pre-wrap fileset
     (c/add-resource fileset (io/file "work")))
   (sift :move {#"incremental-dom/dist/incremental-dom-closure.js"
                "cljsjs/incremental-dom/development/incremental-dom.js"})
   (sift :include #{#"^cljsjs/" #"deps.cljs"})
   (c/with-pass-thru fileset (dosh "make" "clean"))))
