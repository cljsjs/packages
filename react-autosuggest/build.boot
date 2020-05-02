(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "10.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-autosuggest
       :version     +version+
       :description "WAI-ARIA compliant React autosuggest component"
       :url         "https://github.com/moroshko/react-autosuggest.git"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-autosuggest@%s/dist/dist/standalone/autosuggest.js" +lib-version+)
             :target "cljsjs/react-autosuggest/development/react-autosuggest.inc.js")
   (download :url (format "https://unpkg.com/react-autosuggest@%s/dist/dist/standalone/autosuggest.min.js" +lib-version+)
             :target "cljsjs/react-autosuggest/production/react-autosuggest.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-autosuggest"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
