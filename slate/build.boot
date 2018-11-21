(def +lib-version+ "0.33.6")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
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
   (download :url (format "https://unpkg.com/slate@%s/dist/slate.js" +lib-version+)
             :target "cljsjs/slate/development/slate.inc.js")
   (download :url (format "https://unpkg.com/slate@%s/dist/slate.min.js" +lib-version+)
             :target "cljsjs/slate/production/slate.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate"
              :requires ["cljsjs.immutable"])
   (pom)
   (jar)
   (validate)))
