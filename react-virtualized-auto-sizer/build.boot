(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/react-virtualized-auto-sizer
       :version     +version+
       :description "Standalone version of the AutoSizer component from react-virtualized"
       :url         "https://github.com/bvaughn/react-virtualized-auto-sizer"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (let [out "cljsjs/react-virtualized-auto-sizer/production/"]
    (comp
     (download
       :url (str "https://unpkg.com/react-virtualized-auto-sizer@" +lib-version+ "/dist/index.cjs.js")
       :target (str out "react-virtualized-auto-sizer.inc.js"))
     (replace-content
       :in (str out "react-virtualized-auto-sizer.inc.js")
       :match #"var React = require\('react'\);"
       :value "")
     (replace-content
       :in (str out "react-virtualized-auto-sizer.inc.js")
       :match #"module.exports = AutoSizer;"
       :value "")
     (minify
       :in (str out "react-virtualized-auto-sizer.inc.js")
       :out (str out "react-virtualized-auto-sizer.min.inc.js"))
     (sift :include #{#"^cljsjs"})
     (deps-cljs :foreign-libs [{:file #"react-virtualized-auto-sizer.inc.js"
                                :file-min #"react-virtualized-auto-sizer.min.inc.js"
                                :provides ["react-virtualized-auto-sizer"
                                           "cljsjs.react-virtualized-auto-sizer"]
                                :requires ["cljsjs.react"]
                                :global-exports '{react-virtualized-auto-sizer AutoSizer}}]
                :externs [#"react-virtualized-auto-sizer.ext.js"])
     (pom)
     (jar)
     (validate))))
