(def +lib-version+ "1.14.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/emotion "10.0.6-0"]
                  [cljsjs/react "16.9.0-0"]
                  [cljsjs/react-dom "16.9.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-easy-crop
       :version     +version+
       :description "A React component to crop images with easy interactions"
       :url         "https://github.com/ricardo-ch/react-easy-crop"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-easy-crop@%s/dist/standalone/react-easy-crop.js" +lib-version+)
             :target "cljsjs/react-easy-crop/development/react-easy-crop.inc.js")
   (download :url (format "https://unpkg.com/react-easy-crop@%s/dist/standalone/react-easy-crop.min.js" +lib-version+)
             :target "cljsjs/react-easy-crop/production/react-easy-crop.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-easy-crop"
              :requires ["cljsjs.react" "cljsjs.emotion" "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
