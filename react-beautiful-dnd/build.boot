(def +lib-version+ "12.2.0")
(def +version+ (str +lib-version+ "-2"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.12.0-1"]
                  [cljsjs/react-dom "16.12.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-beautiful-dnd
       :version     +version+
       :description "Beautiful, accessible drag and drop for lists with React.js"
       :url         "https://github.com/atlassian/react-beautiful-dnd"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-beautiful-dnd@%s/dist/react-beautiful-dnd.js" +lib-version+)
             :target "cljsjs/react-beautiful-dnd/development/react-beautiful-dnd.inc.js")
   (download :url (format "https://unpkg.com/react-beautiful-dnd@%s/dist/react-beautiful-dnd.min.js" +lib-version+)
             :target "cljsjs/react-beautiful-dnd/production/react-beautiful-dnd.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-beautiful-dnd"
              :requires ["cljsjs.react" "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
