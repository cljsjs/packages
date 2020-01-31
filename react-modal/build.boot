(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "16.3.2-0"]
                 [cljsjs/react-dom "16.3.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.4.4")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-modal
       :version     +version+
       :description "Accessible modal dialog component for React."
       :url         "https://reactjs.github.io/react-modal"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp

   (download :url (format "https://github.com/reactjs/react-modal/archive/v%s.zip" +lib-version+)
             :unzip true)

   (sift :move {#"^react-modal-.*/dist/react-modal.js" "cljsjs/react-modal/development/react-modal.inc.js"})

   (sift :move {#"^react-modal-.*/dist/react-modal.min.js" "cljsjs/react-modal/production/react-modal.min.inc.js"})

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-modal"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
