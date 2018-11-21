(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[boot.task.built-in :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.9")
(def +version+ (str +lib-version+ "-1"))


(task-options!
 pom  {:project     'cljsjs/element-resize-detector
       :version     +version+
       :description "Super-optimized cross-browser resize listener for elements."
       :url         "https://github.com/wnr/element-resize-detector"
       :scm         {:url "https://github.com/wnr/element-resize-detector"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/wnr/element-resize-detector/archive/" +lib-version+ ".zip")
             :checksum "69f4c2122f430fbb265da8451dbf2317"
             :unzip true)
   (show :fileset true) 
   (sift :move {#"^element-resize-detector-.*/dist/element-resize-detector.js" "cljsjs/element-resize-detector/development/element-resize-detector.inc.js"
                #"^element-resize-detector-.*/dist/element-resize-detector.min.js" "cljsjs/element-resize-detector/production/element-resize-detector.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.element-resize-detector")
   (pom)
   (jar)))
