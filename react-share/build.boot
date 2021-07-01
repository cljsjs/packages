(def +lib-version+ "4.4.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'io.github.cljsjs/react-share
       :version     +version+
       :description "A draggable and resizable grid layout with responsive breakpoints, for React."
       :url         "https://github.com/touhonoob/react-share"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/touhonoob/react-share/archive/refs/heads/dist.zip")
              :unzip true)

    (sift :move {#"^react-share-(.*)/dist/react-share.min.js$" "cljsjs/react-share/development/react-share.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-share"
               :requires ["cljsjs.react"])
    (pom)
    (jar)
    (validate)))
