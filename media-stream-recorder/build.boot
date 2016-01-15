(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/media-stream-recorder
       :version     +version+
       :description "Record from your webcam to a File (Blob) in Chrome and Firefox."
       :url         "https://github.com/streamproc/MediaStreamRecorder"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT LICENSE"
                     "https://github.com/streamproc/MediaStreamRecorder/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "https://github.com/streamproc/MediaStreamRecorder/archive/master.zip"
             :unzip true)
   (sift :move {#"MediaStreamRecorder-master/MediaStreamRecorder-standalone.js"
                "cljsjs/development/MediaStreamRecorder-standalone.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.media-stream-recorder")))
