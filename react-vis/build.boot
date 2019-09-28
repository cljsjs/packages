(def +lib-version+ "1.11.7")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/react "16.4.1-0"]
                  [cljsjs/react-dom "16.4.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-vis
       :version     +version+
       :description "Data-Visualization oriented components"
       :url         "https://uber.github.io/react-vis/"
       :scm         {:url "https://github.com/uber/react-vis"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-vis@%s/dist/dist.min.js" +lib-version+))
   (download :url (format "https://unpkg.com/react-vis@%s/dist/style.css" +lib-version+))
   (sift :move {#".*dist.min.js" "cljsjs/react-vis/common/react-vis.inc.js"
                #".*style.css" "cljsjs/react-vis/common/react-vis.inc.css"}) (pom)
   (pom)
   (jar)
   (validate)))
