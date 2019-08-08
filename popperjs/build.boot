(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(def +lib-version+ "1.14.3")
(def +version+ (str +lib-version+ "-1"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/popperjs
       :version     +version+
       :description "A kickass library used to manage poppers in web applications"
       :url         "https://popper.js.org/"
       :scm         {:url "https://github.com/FezVrasta/popper.js"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/popper.js@%s/dist/umd/popper.js" +lib-version+)
             :target "cljsjs/popperjs/development/popper.inc.js")
   (download :url (format "https://unpkg.com/popper.js@%s/dist/umd/popper.min.js" +lib-version+)
             :target "cljsjs/popperjs/production/popper.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.popperjs")
   (pom)
   (jar)
   (validate)))
