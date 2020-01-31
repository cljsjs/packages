(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.5.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/dropzone
       :version     +version+
       :description "DropzoneJS is a library that provides drag’n’drop file uploads with image previews"
       :url         "http://www.dropzonejs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/enyo/dropzone/archive/v%s.zip" +lib-version+)
              :checksum "d062716ee9eb0fe7a2740a887f1f3c10"
              :unzip true)
    (sift :move {#"^dropzone-\d\.\d\.\d/dist/dropzone.js" "cljsjs/dropzone/development/dropzone.inc.js"
                 #"^dropzone-\d\.\d\.\d/dist/dropzone.css" "cljsjs/dropzone/development/dropzone.inc.css"
                 #"^dropzone-\d\.\d\.\d/dist/min/dropzone.min.js" "cljsjs/dropzone/production/dropzone.min.inc.js"
                 #"^dropzone-\d\.\d\.\d/dist/min/dropzone.min.css" "cljsjs/dropzone/common/dropzone.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.dropzone")
    (pom)
    (jar)))
