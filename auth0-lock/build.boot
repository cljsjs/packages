(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "11.8.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom { :project     'cljsjs/auth0-lock
      :version     +version+
      :description "Auth0 Lock"
      :url         "https://auth0.com/docs/libraries/lock"
      :scm         {:url "https://github.com/auth0/lock"}
      :license     {"MIT" "https://github.com/auth0/lock/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/auth0/lock/archive/v%s.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^lock.*/build/lock\.js$"
                "cljsjs/auth0-lock/development/lock.inc.js"
                #"^lock.*/build/lock\.min\.js$"
                "cljsjs/auth0-lock/production/lock.min.inc.js" })
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.auth0-lock")
   (pom)
   (jar)
   (validate)))
