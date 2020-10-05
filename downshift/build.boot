(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/downshift
        :version     +version+
        :description "Primitives to build simple, flexible, WAI-ARIA compliant React autocomplete, combobox or select dropdown components."
        :url         "https://github.com/downshift-js/downshift"
        :license     {"MIT" "https://raw.githubusercontent.com/downshift-js/downshift/v6.0.6/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/downshift@" +lib-version+ "/dist/downshift.umd.js")
              :target "cljsjs/downshift/development/downshift.inc.js")
    (download :url (str "https://unpkg.com/downshift@" +lib-version+ "/dist/downshift.umd.js.map")
              :target "cljsjs/downshift/development/downshift.umd.js.map")
    (download :url (str "https://unpkg.com/downshift@" +lib-version+ "/dist/downshift.umd.min.js")
              :target "cljsjs/downshift/production/downshift.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"downshift.inc.js"
                              :file-min #"downshift.min.inc.js"
                              :provides ["downshift" "cljsjs.downshift"]
                              :global-exports '{downshift Downshift}}]
              :externs [#"downshift.ext.js"])
   (pom)
   (jar)
   (validate)))
