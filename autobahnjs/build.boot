(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom {:project     'cljsjs/autobahnjs
       :version     +version+
       :description "AutobahnJS - A JavaScript library for WAMP (\" The Web Application Messaging Protocol \"). http://autobahn.ws"
       :url         "https://github.com/crossbario/autobahn-js"
       :license     {"MIT" "https://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
         (comp
           (download :url (str "https://autobahn.s3.amazonaws.com/autobahnjs/" +lib-version+ "/autobahn.js"))
           (download :url (str "https://autobahn.s3.amazonaws.com/autobahnjs/" +lib-version+ "/autobahn.min.js"))
           (sift :move {#"^autobahn\.js"      "cljsjs/autobahnjs/development/autobahn.inc.js"
                        #"^autobahn\.min\.js" "cljsjs/autobahnjs/production/autobahn.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.autobahn")))
