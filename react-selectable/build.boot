(def +lib-version+ "0.2.5")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/react       "0.14.7-0" :scope "provided"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-selectable
       :version     +version+
       :description "A component for react that allows mouse selection of child items"
       :url         "https://github.com/unclecheese/react-selectable"
       :scm         {:url "https://github.com/unclecheese/react-selectable"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (str "https://raw.githubusercontent.com/unclecheese/react-selectable/f4edb22ed06228f2236331e012856c68584f4f56/dist/react-selectable.js")
              :checksum "6994880bfd617146215ad6080ab67e7f")
    (sift :move {#"^react-selectable.js$"
                 "cljsjs/react-selectable/development/react-selectable.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-selectable" :requires ["cljsjs.react"])
    (pom)
    (jar)))
