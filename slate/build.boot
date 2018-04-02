(def +lib-version+ "0.33.4")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
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
             :checksum "04b5542a4e40a4c07ffb24972cba1905")
   (download :url (str "https://unpkg.com/slate@" +lib-version+  "/dist/slate.min.js")
             :checksum "540ce9f0ce48e97fff0aa160dcd272f1")
   (sift :move {#"^slate.js$"
                "cljsjs/slate/development/slate.inc.js"
                #"^slate.min.js"
                "cljsjs/slate/production/slate.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate"
              :requires ["cljsjs.immutable"])
   (pom)
   (jar)))
