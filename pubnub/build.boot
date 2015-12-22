(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.7.15")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pubnub
       :version     +version+
       :description "Interface for pubnub realtime messaging services"
       :url         "http://www.pubnub.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"???" "https://github.com/pubnub/javascript/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://cdn.pubnub.com/pubnub-" +lib-version+ ".js")
             :checksum "3AECB671E6E8BC8D4590EE58976D5981")
   (download :url (str "https://cdn.pubnub.com/pubnub-" +lib-version+ ".min.js")
             :checksum "15626328946E5EDD08D55C07A1971E6D")
   (sift :move {(re-pattern (str "^pubnub-" +lib-version+ ".js$"))
                "cljsjs/pubnub/development/pubnub.inc.js"
                (re-pattern (str "^pubnub-" +lib-version+ ".min.js$"))
                "cljsjs/pubnub/production/pubub.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pubnub")))
