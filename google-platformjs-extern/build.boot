(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/google-platformjs-extern
        :version     +version+
        :description "Authenticate with Google API"
        :url         "https://apis.google.com/js/platform.js"
        :license     {"" ""}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (pom)
   (jar)))
