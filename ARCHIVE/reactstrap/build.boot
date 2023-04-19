(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.3.2-0"]
                  [cljsjs/react-dom "16.3.2-0" :exclusions [cljsjs/react]]
                  [cljsjs/react-transition-group "2.3.1-0" :exclusions [cljsjs/react
                                                                        cljsjs/react-dom]]
                  [cljsjs/react-popper "0.10.4-0" :exclusions [cljsjs/react
                                                               cljsjs/react-dom]]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/reactstrap
       :version     +version+
       :description "Simple React Bootstrap 4 components"
       :url         "https://reactstrap.github.io/"
       :scm         {:url "https://github.com/reactstrap/reactstrap"}
       :license     {"MIT" "https://github.com/reactstrap/reactstrap/blob/master/LICENSE"}})

(defn download-url
      [min?]
      (format "https://unpkg.com/reactstrap@%s/dist/reactstrap.%sjs" +lib-version+ (if min? "min." "")))

(deftask package []
         (comp
           (download :url (download-url false) :name "reactstrap.js")
           (download :url (download-url true) :name "reactstrap.min.js")
           (sift :move {#"reactstrap.js"     "cljsjs/reactstrap/development/reactstrap.inc.js"
                        #"reactstrap.min.js" "cljsjs/reactstrap/production/reactstrap.min.inc.js"})
           (deps-cljs :name "cljsjs.reactstrap" :requires ["cljsjs.react"
                                                           "cljsjs.react.dom"
                                                           "cljsjs.react-transition-group"
                                                           "cljsjs.react-popper"])
           (pom)
           (jar)
           (validate)))
