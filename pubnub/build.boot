(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.8.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pubnub
       :version     +version+
       :description "Interface for pubnub realtime messaging services"
       :url         "http://www.pubnub.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://github.com/pubnub/javascript/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://cdn.pubnub.com/pubnub-" +lib-version+ ".js")
             :checksum "A1B5629A42900593DD93067878A595E9")
   (download :url (str "https://cdn.pubnub.com/pubnub-" +lib-version+ ".min.js")
             :checksum "FB4F9B1B2AF2415741072CD0BAFC4E78")
   (sift :move {(re-pattern (str "^pubnub-" +lib-version+ ".js$"))
                "cljsjs/pubnub/development/pubnub.inc.js"
                (re-pattern (str "^pubnub-" +lib-version+ ".min.js$"))
                "cljsjs/pubnub/production/pubub.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pubnub")))
