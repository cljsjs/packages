(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.5")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/lunrjs
       :version     +version+
       :description "Lunr.js is a small, full-text search library for
       use in the browser. It indexes JSON documents and provides a
       simple search interface for retrieving documents that best
       match text queries."
       :url         "http://github.com/olivernn/lunr.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/lunr.js/%s/lunr.js" +lib-version+))
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/lunr.js/%s/lunr.min.js" +lib-version+))
   (sift :move {#"^lunr\.js" "cljsjs/lunrjs/development/lunrjs.inc.js"})
   (sift :move {#"^lunr\.min\.js" "cljsjs/lunrjs/production/lunrjs.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.lunrjs")
   (pom)
   (jar)
   (validate)))
