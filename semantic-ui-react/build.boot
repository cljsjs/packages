(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.87.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/semantic-ui-react
       :version     +version+
       :description "React components for Semantic UI"
       :url         "http://react.semantic-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/semantic-ui-react@" +lib-version+ "/dist/umd/semantic-ui-react.min.js")
              :target "cljsjs/semantic-ui-react/common/semantic-ui-react.inc.js")
    (deps-cljs :requires ["cljsjs.react" "cljsjs.react.dom"]
               :provides ["cljsjs.semantic-ui-react"]
               :global-exports '{cljsjs.semantic-ui-react semanticUIReact})
    (pom :project 'cljsjs/semantic-ui-react
         :dependencies [['cljsjs/react "16.3.0-0"]
                        ['cljsjs/react-dom "16.3.0-0"]])
    (jar)
    (validate)))
