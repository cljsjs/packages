(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.12")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/tock
      :version     +version+
      :description "A javscript timer/countdown clock"
      :url         "https://github.com/mrchimp/tock"
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp

   (download :url "https://raw.githubusercontent.com/mrchimp/tock/master/tock.js")
   (download :url "https://raw.githubusercontent.com/mrchimp/tock/master/tock.min.js")

   (sift :move {#"^tock\.js"       "cljsjs/tock/development/tock.inc.js"
                #"^tock\.min.\.js" "cljsjs/tock/production/tock.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.tock")

   (pom)
   (jar)
   (validate-checksums)))
