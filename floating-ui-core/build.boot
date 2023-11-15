(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/floating-ui-core
       :version     +version+
       :description "Floating UI Core library"
       :url         "https://github.com/floating-ui/floating-ui"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/@floating-ui/core@" +lib-version+ "/dist/floating-ui.core.umd.js")
             :target "cljsjs/floating-ui-core/development/floating-ui-core.inc.js")
   (download :url (str "https://unpkg.com/@floating-ui/core@" +lib-version+ "/dist/floating-ui.core.umd.min.js")
             :target "cljsjs/floating-ui-core/production/floating-ui-core.min.inc.js")
   (deps-cljs :foreign-libs [{:file #"cljsjs/floating-ui-core/development/floating-ui-core.inc.js"
                              :file-min #"cljsjs/floating-ui-core/production/floating-ui-core.min.inc.js"
                              :provides ["@floating-ui/core"]
                              :global-exports '{"@floating-ui/core" FloatingUICore}}]
              :externs [#"floating-ui-core.ext.js"])
   (pom)
   (jar)
   (validate)))
