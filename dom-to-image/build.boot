(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "2.6.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/dom-to-image
        :version     +version+
        :description "Generates an image from a DOM node using HTML5 canvas"
        :url         "https://github.com/tsayen/dom-to-image"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format
                     "https://raw.githubusercontent.com/tsayen/dom-to-image/%s/src/dom-to-image.js"
                     +lib-version+)
              :checksum "4a48869c66c27f8444293825eb2c3f72")
    (download :url (format
                     "https://unpkg.com/dom-to-image@%s/dist/dom-to-image.min.js"
                     +lib-version+)
              :checksum "8d5f56399c6a637773f05780906dc1f8")
    (sift :move {#"^dom-to-image\.js"
                 "cljsjs/dom-to-image/development/dom-to-image.inc.js"
		 #"^dom-to-image\.min\.js"
                 "cljsjs/dom-to-image/production/dom-to-image.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.dom-to-image")
    (pom)
    (jar)))

