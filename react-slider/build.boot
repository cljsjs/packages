(def +lib-version+ "0.6.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                 [cljsjs/react       "0.14.7-0" :scope "provided"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-slider
       :version     +version+
       :description "Slider component for React"
       :url         "https://github.com/mpowaga/react-slider"
       :scm         {:url "https://github.com/mpowaga/react-slider"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
   (download :url (str "https://raw.githubusercontent.com/mpowaga/react-slider/v" +lib-version+  "/react-slider.js")
             :checksum "2e0a453b2d42aeb7da2b5b9c7f6168d9")
   (minify :in (str "react-slider.js")
           :out (str "react-slider.min.js"))
   (sift :move {#"^react-slider.js$"
                "cljsjs/react-slider/development/react-slider.inc.js"
                #"^react-slider.min.js"
                "cljsjs/react-slider/production/react-slider.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-slider" :requires ["cljsjs.react"])
   (pom)
   (jar)))
