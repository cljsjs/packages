(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.1")
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
   (download :url (str "https://cdn.pubnub.com/sdk/javascript/pubnub." +lib-version+ ".js")
             :checksum "FB4AA4C47D72F0ABA9FE3B6751562461")
   (download :url (str "https://cdn.pubnub.com/sdk/javascript/pubnub." +lib-version+ ".min.js")
             :checksum "2BFA093ED20BA285CCBD4026D941CE23")
   (sift :move {(re-pattern (str "^pubnub." +lib-version+ ".js$"))
                "cljsjs/pubnub/development/pubnub.inc.js"
                (re-pattern (str "^pubnub." +lib-version+ ".min.js$"))
                "cljsjs/pubnub/production/pubub.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pubnub")
   (pom)
   (jar)))
