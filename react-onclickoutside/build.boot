(def +lib-version+ "4.9.0")
(def +version+ (str +lib-version+ "-2"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/object-assign-shim "0.1.0-1"]
                  [cljsjs/react "15.3.0-0"]])

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
    (download :url (str "https://raw.githubusercontent.com/Pomax/react-onclickoutside/v" +lib-version+ "/index.js")
              :checksum "d5d4b34e43de6ac24e850ab8a027a726")
    (sift :move {#"^index.js$"
                 "cljsjs/react-onclickoutside/development/react-onclickoutside.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-onclickoutside"
               :requires ["cljsjs.react"
                          "cljsjs.object-assign-shim"])
    (pom)
    (jar)))
