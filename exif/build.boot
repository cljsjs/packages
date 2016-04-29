(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/exif
       :version     +version+
       :description (str "A JavaScript library for reading EXIF meta data"
                         " from JPEG image files.")
       :url         "https://github.com/exif-js/exif-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/exif-js/exif-js/archive/v" 
                        +lib-version+ ".zip")
              :checksum "ED87B87C05A8ABB43CB27D6616A1CCE3"
              :unzip true)
    (sift :move {#"^exif-js-([\d\.]*)/exif\.js" 
                 "cljsjs/exif/development/exif.inc.js"})
    (minify :in "cljsjs/exif/development/exif.inc.js" 
            :out "cljsjs/exif/production/exif.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.exif")
    (pom)
    (jar)))
