(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "16.6.0-0"]
                  [cljsjs/react-dom "16.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.9.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/react-tooltip-lite
       :version     +version+
       :description "A lightweight and responsive tooltip"
       :url         "https://github.com/bsidelinger912/react-tooltip-lite"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/react-tooltip-lite@" +lib-version+ "/dist/react-tooltip-lite.min.js"))
   (sift :move {#".*react-tooltip-lite.min.js" "cljsjs/react-tooltip-lite/development/react-tooltip-lite.inc.js"})
   (download :url (str "https://unpkg.com/react-tooltip-lite@" +lib-version+ "/dist/react-tooltip-lite.min.js"))
   (sift :move {#".*react-tooltip-lite.min.js" "cljsjs/react-tooltip-lite/production/react-tooltip-lite.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-tooltip-lite"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)))
