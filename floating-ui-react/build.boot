(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "17.0.1-0"]
                 [cljsjs/react-dom "17.0.1-0"]
                 [io.github.cljsjs/floating-ui-react-dom "2.0.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.24.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/floating-ui-react
       :version     +version+
       :description "Floating UI React library"
       :url         "https://github.com/floating-ui/floating-ui"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/@floating-ui/react@" +lib-version+ "/dist/floating-ui.react.umd.js")
             :target "cljsjs/floating-ui-react/development/floating-ui-react.inc.js")
   (download :url (str "https://unpkg.com/@floating-ui/react@" +lib-version+ "/dist/floating-ui.react.umd.min.js")
             :target "cljsjs/floating-ui-react/production/floating-ui-react.min.inc.js")
   (deps-cljs :foreign-libs [{:file #"cljsjs/floating-ui-react/development/floating-ui-react.inc.js"
                              :file-min #"cljsjs/floating-ui-react/production/floating-ui-react.min.inc.js"
                              :provides ["@floating-ui/react"]
                              :requires ["react" "react-dom" "@floating-ui/react-dom"]
                              :global-exports '{"@floating-ui/react" FloatingUIReact}}]
              :externs [#"floating-ui-react.ext.js"])
   (pom)
   (jar)
   (validate)))
