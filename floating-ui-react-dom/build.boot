(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "17.0.1-0"]
                 [cljsjs/react-dom "17.0.1-0"]
                 [io.github.cljsjs/floating-ui-dom "1.2.9-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/floating-ui-react-dom
       :version     +version+
       :description "Floating UI React DOM library"
       :url         "https://github.com/floating-ui/floating-ui"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://cdn.jsdelivr.net/npm/@floating-ui/react-dom@" +lib-version+ "/dist/floating-ui.react-dom.umd.js")
             :target "cljsjs/floating-ui-react-dom/development/floating-ui-react-dom.inc.js")
   (download :url (str "https://cdn.jsdelivr.net/npm/@floating-ui/react-dom@" +lib-version+ "/dist/floating-ui.react-dom.umd.min.js")
             :target "cljsjs/floating-ui-react-dom/production/floating-ui-react-dom.min.inc.js")
   (deps-cljs :foreign-libs [{:file #"cljsjs/floating-ui-react-dom/development/floating-ui-react-dom.inc.js"
                              :file-min #"cljsjs/floating-ui-react-dom/production/floating-ui-react-dom.min.inc.js"
                              :provides ["@floating-ui/react-dom"]
                              :requires ["react" "react-dom" "@floating-ui/dom"]
                              :global-exports '{"@floating-ui/react-dom" FloatingUIReactDOM}}]
              :externs [#"floating-ui-react-dom.ext.js"])
   (pom)
   (jar)
   (validate)))
