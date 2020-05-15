(def +lib-version+ "0.58.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.10.2-0"]
                 [cljsjs/react-dom "16.10.2-0"]
                 [cljsjs/slate "0.58.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/slate-react
       :version     +version+
       :description "A completely customizable framework for building rich text editors."
       :url         "http://slatejs.org"
       :scm         {:url "https://github.com/ianstormtaylor/slate"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/slate-react@%s/dist/slate-react.js" +lib-version+)
             :target "cljsjs/slate-react/development/slate-react.inc.js")
   (download :url (format "https://unpkg.com/slate-react@%s/dist/slate-react.min.js" +lib-version+)
             :target "cljsjs/slate-react/production/slate-react.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"slate-react\.inc\.js"
                              :file-min       #"slate-react\.min\.inc\.js"
                              :requires       ["cljsjs.react" "cljsjs.react.dom" "cljsjs.slate"]
                              :provides       ["slate-react" "cljsjs.slate-react"]
                              :global-exports '{slate-react SlateReact}}]
              :externs [#"slate-react\.ext\.js"])

   (pom)
   (jar)
   (validate)))
