(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [io.github.cljsjs/floating-ui-core "1.2.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/floating-ui-dom
       :version     +version+
       :description "Floating UI DOM library"
       :url         "https://github.com/floating-ui/floating-ui"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/@floating-ui/dom@" +lib-version+ "/dist/floating-ui.dom.umd.js")
             :target "cljsjs/floating-ui-dom/development/floating-ui-dom.inc.js")
   (download :url (str "https://unpkg.com/@floating-ui/dom@" +lib-version+ "/dist/floating-ui.dom.umd.min.js")
             :target "cljsjs/floating-ui-dom/production/floating-ui-dom.min.inc.js")
   (deps-cljs :foreign-libs [{:file #"cljsjs/floating-ui-dom/development/floating-ui-dom.inc.js"
                              :file-min #"cljsjs/floating-ui-dom/production/floating-ui-dom.min.inc.js"
                              :provides ["@floating-ui/dom"]
                              :requires ["@floating-ui/core"]
                              :global-exports '{"@floating-ui/dom" FloatingUIDOM}}]
              :externs [#"floating-ui-dom.ext.js"])
   (pom)
   (jar)
   (validate)))
