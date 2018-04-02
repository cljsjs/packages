(def +lib-version+ "0.12.4")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                 [cljsjs/react "16.3.0-0"]
                 [cljsjs/react-dom "16.3.0-0"]
                 [cljsjs/slate "0.33.4-0"]])

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
             :checksum "0c271702870fb678f261c7429881dae6")
   (download :url (str "https://unpkg.com/slate-react@" +lib-version+  "/dist/slate-react.min.js")
             :checksum "cc9e3089ce87205d2e5d72747351d298")
   (sift :move {#"^slate-react.js$"
                "cljsjs/slate-react/development/slate-react.inc.js"
                #"^slate-react.min.js"
                "cljsjs/slate-react/production/slate-react.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate-react"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.slate"])
   (pom)
   (jar)))
