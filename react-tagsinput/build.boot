(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react "15.0.0-0"]
                  [cljsjs/react-dom "15.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.17.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-tagsinput
       :version     +version+
       :description "Highly customizable React component for inputing tags."
       :url         "https://github.com/olahol/react-tagsinput"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/olahol/react-tagsinput/archive/" +lib-version+ ".zip")
             :checksum "d84aa18908dfae5624a4790f0243e7e1"
             :unzip true)

   (sift :move {#"^react-tagsinput-.*/react-tagsinput.js$" "cljsjs/react-tagsinput/common/react-tagsinput.inc.js"
                #"^react-tagsinput-.*/react-tagsinput.css$" "cljsjs/react-tagsinput/common/react-tagsinput.inc.css"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-tagsinput"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)))
