(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def auth0-lock-version "7.7.1")
(def +version+ (str auth0-lock-version "-0"))
(bootlaces! +version+)

(task-options!
 pom { :project     'cljsjs/auth0-lock
       :version     +version+
       :description "Auth0 Lock"
       :url         "https://auth0.com/docs/libraries/lock"
       :scm         { :url "https://github.com/auth0/lock" }
       :license     { "MIT" "https://github.com/auth0/lock/blob/master/LICENSE" }})

(deftask package []
  (comp
    (download :url "https://github.com/auth0/lock/archive/v7.7.1.zip"
              :unzip true)
    (sift :move { #"^lock.*/build/auth0-lock\.js$"      "cljsjs/auth0-lock/development/auth0-lock.inc.js"
                  #"^lock.*/build/auth0-lock\.min\.js$" "cljsjs/auth0-lock/production/auth0-lock.min.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.auth0-lock")))
