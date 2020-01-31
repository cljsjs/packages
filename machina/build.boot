(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/lodash "3.10.1-0"]])

(def +lib-version+ "2.0.2")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/machina
       :version     +version+
       :description "a JavaScript framework for highly customizable finite state machines (FSMs)"
       :url         "https://github.com/ifandelse/machina.js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/machina@%s/lib/machina.js" +lib-version+)
             :target "cljsjs/machina/development/machina.inc.js")
   (download :url (format "https://unpkg.com/machina@%s/lib/machina.min.js" +lib-version+)
             :target "cljsjs/machina/production/machina.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.machina"
              :requires ["cljsjs.lodash"])
   (pom)
   (jar)
   (validate)))
