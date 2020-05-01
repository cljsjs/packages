(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(def +lib-version+ "2.4.0")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/popperjs-core
       :version     +version+
       :description "A tooltip and popover positioning engine"
       :url         "https://popper.js.org/"
       :scm         {:url "https://github.com/popperjs/popper-core"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/@popperjs/core@%s/dist/umd/popper.js" +lib-version+)
             :target "cljsjs/popperjs-core/development/popper.inc.js")
   (download :url (format "https://unpkg.com/@popperjs/core@%s/dist/umd/popper.min.js" +lib-version+)
             :target "cljsjs/popperjs-core/production/popper.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.popperjs-core")
   (pom)
   (jar)
   (validate)))
