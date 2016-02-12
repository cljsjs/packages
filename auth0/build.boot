(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom { :project     'cljsjs/auth0
       :version     +version+
       :description "auth0.js is a UI-less client-side library for Auth0"
       :url         "https://auth0.com/docs/auth0js"
       :scm         { :url "https://github.com/auth0/auth0.js" }
       :license     { "MIT" "https://github.com/auth0/auth0.js/blob/master/LICENSE.txt" }})

(deftask package []
  (comp
    (download :url (format "https://github.com/auth0/auth0.js/archive/v%s.zip" +lib-version+)
              :checksum "70f3282eea62686fdda6afff713e2a9d"
              :unzip true)
    (sift :move { #"^auth0\.js.*/build/auth0\.js$"      "cljsjs/auth0/development/auth0.inc.js"
                  #"^auth0\.js.*/build/auth0\.min\.js$" "cljsjs/auth0/production/auth0.min.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.auth0")))
