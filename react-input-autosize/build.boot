(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.6.1-2"]
                  [cljsjs/prop-types "15.5.10-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-input-autosize
       :version     +version+
       :description "Auto-resizing input field for React"
       :url         "http://jedwatson.github.io/react-input-autosize/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/react-input-autosize@%s/dist/react-input-autosize.js" +lib-version+)
              :target "cljsjs/react-input-autosize/development/react-input-autosize.inc.js")
    (download :url (format "https://unpkg.com/react-input-autosize@%s/dist/react-input-autosize.min.js" +lib-version+)
              :target "cljsjs/react-input-autosize/production/react-input-autosize.min.inc.js")
    (deps-cljs :provides ["react-input-autosize" "cljsjs.react-input-autosize"]
               :requires ["cljsjs.react" "cljsjs.prop-types"]
               :global-exports '{react-input-autosize AutosizeInput})
    (pom)
    (jar)))
