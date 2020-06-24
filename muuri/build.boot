(def +lib-version+ "0.9.0")
(def +version+ (str +lib-version+ "-2"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/muuri
       :version     +version+
       :description "Infinite responsive, sortable, filterable and draggable layouts"
       :url         "https://github.com/haltu/muuri"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/muuri@%s/dist/muuri.js" +lib-version+)
             :target "cljsjs/muuri/development/muuri.inc.js")
   (download :url (format "https://unpkg.com/muuri@%s/dist/muuri.min.js" +lib-version+)
             :target "cljsjs/muuri/production/muuri.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.muuri")
   (pom)
   (jar)
   (validate)))