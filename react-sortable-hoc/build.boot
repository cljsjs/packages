(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react "16.3.0-1"]
                  [cljsjs/react-dom "16.3.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.8.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-sortable-hoc
       :version     +version+
       :description "A set of higher-order components to turn any list into an animated, touch-friendly, sortable list."
       :url         "http://clauderic.github.io/react-sortable-hoc/"
       :scm         {:url "https://github.com/clauderic/react-sortable-hoc"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-sortable-hoc@%s/dist/umd/react-sortable-hoc.js" +lib-version+)
             :target "cljsjs/react-sortable-hoc/development/react-sortable-hoc.inc.js")
   (download :url (format "https://unpkg.com/react-sortable-hoc@%s/dist/umd/react-sortable-hoc.min.js" +lib-version+)
             :target "cljsjs/react-sortable-hoc/production/react-sortable-hoc.min.inc.js")

   (deps-cljs :name "cljsjs.react-sortable-hoc"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
