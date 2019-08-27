(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.9.0" :scope "provided"]
                  [cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.19.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/react-json-view
       :version     +version+
       :description "Interactive react component for displaying javascript arrays and JSON objects."
       :url         "https://github.com/mac-s-g/react-json-view"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
         (comp

           (download :url (format "https://unpkg.com/react-json-view@%s/dist/main.js" +lib-version+)
                     :unzip false)

           (sift :move {#"^main.js" "cljsjs/react-json-view/development/react-json-view.inc.js"})

           (sift :move {#"^main.js" "cljsjs/react-json-view/production/react-json-view.inc.js"})

           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.react-json-view"
                      :requires ["cljsjs.react"
                                 "cljsjs.react.dom"])
           (pom)
           (jar)
           (validate)))