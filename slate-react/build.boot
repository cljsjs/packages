(def +lib-version+ "0.10.17")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.8.2" :scope "test"]
                 [cljsjs/react "15.6.2-2"]
                 [cljsjs/react-dom "15.6.2-2"]
                 [cljsjs/slate "0.31.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/slate-react
       :version     +version+
       :description "A completely customizable framework for building rich text editors."
       :url         "http://slatejs.org"
       :scm         {:url "https://github.com/ianstormtaylor/slate"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (comp
   (download :url (str "https://unpkg.com/slate-react@" +lib-version+  "/dist/slate-react.js")
             :checksum "fa66ac4055034ee358e698bfeca15d91")
   (download :url (str "https://unpkg.com/slate-react@" +lib-version+  "/dist/slate-react.min.js")
             :checksum "cdf10cc4fb391af9a817fc13825d6e5a")
   (sift :move {#"^slate-react.js$"
                "cljsjs/slate-react/development/slate-react.inc.js"
                #"^slate-react.min.js"
                "cljsjs/slate-react/production/slate-react.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate-react"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.slate"])
   (pom)
   (jar)))
