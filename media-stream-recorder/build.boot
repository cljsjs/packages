(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.6.2-0")

(task-options!
 pom  {:project     'cljsjs/media-stream-recorder
       :version     +version+
       :description "Record from your webcam to a File in Chrome and Firefox."
       :url         "https://github.com/streamproc/MediaStreamRecorder"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT LICENSE"
                     "https://github.com/streamproc/MediaStreamRecorder/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "https://github.com/streamproc/MediaStreamRecorder/archive/master.zip"
             :unzip true)
    ;; (sift :move {#"firebase-bower-([\d\.]*)/firebase.js" "cljsjs/development/firebase.inc.js"})
    ;; (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.media-stream-recorder")))
