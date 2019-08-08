(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.12")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/tock
      :version     +version+
      :description "An accurate JavaScript timer/countdown"
      :url         "https://github.com/mrchimp/tock"
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp

   (download :url "https://raw.githubusercontent.com/mrchimp/tock/v1.0.12/tock.js"
             :target "cljsjs/tock/development/tock.inc.js")
   (download :url "https://raw.githubusercontent.com/mrchimp/tock/v1.0.12/tock.min.js"
             :target "cljsjs/tock/production/tock.min.inc.js")

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.tock")

   (pom)
   (jar)
   (validate)))
