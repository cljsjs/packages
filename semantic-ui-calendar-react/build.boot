(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.15.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/semantic-ui-calendar-react
       :version     +version+
       :description "Datepicker react component based on semantic-ui-react components"
       :url         "https://github.com/arfedulov/semantic-ui-calendar-react"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
         (comp
           (download :url (str "https://unpkg.com/semantic-ui-calendar-react@" +lib-version+ "/dist/umd/semantic-ui-calendar-react.js")
                     :target "cljsjs/semantic-ui-calendar-react/common/semantic-ui-calendar-react.inc.js")
           (deps-cljs :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.semantic-ui-react"]
                      :provides ["cljsjs.semantic-ui-calendar-react"]
                      :global-exports '{cljsjs.semantic-ui-calendar-react semantic-ui-calendar-react})
           (pom :project 'cljsjs/semantic-ui-calendar-react
                :dependencies [['cljsjs/react "16.13.1-0"]
                               ['cljsjs/react-dom "16.13.1-0"]
                               ['cljsjs/semantic-ui-react "0.88.1-0"]])
           (jar)
           (validate)))