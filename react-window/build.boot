(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.8.7")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/react-window
        :version     +version+
        :description "React components for efficiently rendering large lists and tabular data"
        :url         "https://react-window.now.sh/"
        :license     {"MIT" "https://github.com/bvaughn/react-window/blob/1.8.7/LICENSE.md"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (let [src "cljsjs/react-window/production/react-window.min.inc.js"]
    (comp
     (download
       :url (str "https://unpkg.com/react-window@" +lib-version+ "/dist/index-prod.umd.js")
       :target src)
     (replace-content
       :in src
       :match #"\/\/\# sourceMappingURL=.*"
       :value "")
     (sift :include #{#"^cljsjs"})
     (deps-cljs :foreign-libs [{:file #"react-window.min.inc.js"
                                :provides ["react-window" "cljsjs.react-window"]
                                :requires ["cljsjs.react" "cljsjs.react.dom"]
                                :global-exports '{react-window ReactWindow}}]
                :externs [#"react-window.ext.js"])
     (pom)
     (jar)
     (validate))))
