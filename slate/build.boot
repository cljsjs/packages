(def +lib-version+ "0.14.14")
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
             :checksum "9E142C98523A63B22EEE124973EEC4C6")
   (download :url (str "https://unpkg.com/slate@" +lib-version+  "/dist/slate.min.js")
             :checksum "6CDDB29BBE2F351AF27BA2EDC7758FE3")
   (sift :move {#"^slate.js$"
                "cljsjs/slate/development/slate.inc.js"
                #"^slate.min.js"
                "cljsjs/slate/production/slate.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.immutable"])
   (pom)
   (jar)))
