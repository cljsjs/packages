(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "16.3.0-1"]
                  [cljsjs/react-dom "16.3.0-1"]
                  [cljsjs/prop-types "15.7.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.11.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-sortable-hoc
       :version     +version+
       :description "A set of higher-order components to turn any list into an animated, touch-friendly, sortable list."
       :url         "http://clauderic.github.io/react-sortable-hoc/"
       :scm         {:url "https://github.com/clauderic/react-sortable-hoc"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-sortable-hoc@%s/dist/react-sortable-hoc.umd.js" +lib-version+)
             :target "cljsjs/react-sortable-hoc/development/react-sortable-hoc.inc.js")
   (download :url (format "https://unpkg.com/react-sortable-hoc@%s/dist/react-sortable-hoc.umd.min.js" +lib-version+)
             :target "cljsjs/react-sortable-hoc/production/react-sortable-hoc.min.inc.js")
   (deps-cljs :foreign-libs [{:file #"react-sortable-hoc.inc.js"
                              :file-min #"react-sortable-hoc.min.inc.js"
                              :provides ["react-sortable-hoc" "cljsjs.react-sortable-hoc"]
                              :global-exports {"react-sortable-hoc" "SortableHOC"}
                              :requires ["react"
                                         "react-dom"
                                         "prop-types"]}]
              :externs [#"react-sortable-hoc.ext.js"])
   (pom)
   (jar)
   (validate)))
