(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "8.1.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom { :project     'cljsjs/auth0-lock
       :version     +version+
       :description "Auth0 Lock"
       :url         "https://auth0.com/docs/libraries/lock"
       :scm         { :url "https://github.com/auth0/lock" }
       :license     { "MIT" "https://github.com/auth0/lock/blob/master/LICENSE" }})

(deftask package []
  (comp
    (download :url (format "https://github.com/auth0/lock/archive/v%s.zip" +lib-version+)
              :unzip true)
    (sift :move { #"^lock.*/build/auth0-lock\.js$"      "cljsjs/auth0-lock/development/auth0-lock.inc.js"
                  #"^lock.*/build/auth0-lock\.min\.js$" "cljsjs/auth0-lock/production/auth0-lock.min.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.auth0-lock")))
