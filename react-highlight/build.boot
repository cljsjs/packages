(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.3.0-0"]
                  [cljsjs/prop-types "15.6.0-0"]
                  [cljsjs/highlight "9.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-highlight
       :version     +version+
       :description "A simple React wrapper around the Highlight.js library"
       :url         "https://github.com/bvaughn/react-highlight.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
         (comp
           (download :url (format "https://unpkg.com/react-highlight.js@%s/dist/main.js" +lib-version+)
                     :target "cljsjs/prop-types/development/prop-types.inc.js")
           (minify :in "cljsjs/prop-types/development/prop-types.inc.js"
                   :out "cljsjs/prop-types/development/prop-types.min.inc.js")
           (deps-cljs :name "cljsjs.react-highlight"
                      :requires ["cljsjs.react"
                                 "cljsjs.prop-types"
                                 "cljsjs.highlight"])
           (pom)
           (jar)))
