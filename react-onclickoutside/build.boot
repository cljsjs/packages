(def +lib-version+ "6.7.1")
(def +version+ (str +lib-version+ "-1"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/react "16.3.0-1"]
                 [cljsjs/react-dom "16.3.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-onclickoutside
       :version     +version+
       :description "An onClickOutside mixin for React components"
       :url         "https://github.com/Pomax/react-onclickoutside"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (comp
   (download :url (format "https://unpkg.com/react-onclickoutside@%s/dist/react-onclickoutside.js" +lib-version+)
             :target "cljsjs/react-onclickoutside/development/react-onclickoutside.inc.js")
   (download :url (format "https://unpkg.com/react-onclickoutside@%s/dist/react-onclickoutside.min.js" +lib-version+)
             :target "cljsjs/react-onclickoutside/production/react-onclickoutside.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-onclickoutside"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate-checksums)))
