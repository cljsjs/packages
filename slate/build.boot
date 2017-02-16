(def +lib-version+ "0.16.17")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                 [cljsjs/immutable "3.8.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/slate
       :version     +version+
       :description "A completely customizable framework for building rich text editors."
       :url         "http://slatejs.org"
       :scm         {:url "https://github.com/ianstormtaylor/slate"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (comp
   (download :url (str "https://unpkg.com/slate@" +lib-version+  "/dist/slate.js")
             :checksum "F8406587D870807830063FA91C5B5729")
   (download :url (str "https://unpkg.com/slate@" +lib-version+  "/dist/slate.min.js")
             :checksum "0139098B95FFEBEF4FE546214EA6AD50")
   (sift :move {#"^slate.js$"
                "cljsjs/slate/development/slate.inc.js"
                #"^slate.min.js"
                "cljsjs/slate/production/slate.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.immutable"])
   (pom)
   (jar)))
