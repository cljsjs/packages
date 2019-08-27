(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.7.1")
(def +version+ (str +lib-version+ "-1"))

(def unpkg-dist-url (str "https://unpkg.com/oidc-client@" +lib-version+ "/dist"))

(task-options!
 pom  {:project     'cljsjs/oidc-client
       :version     +version+
       :description "OpenID Connect (OIDC) and OAuth2 protocol support for browser-based JavaScript applications"
       :url         "https://github.com/IdentityModel/oidc-client-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str unpkg-dist-url "/oidc-client.js"))
   (download :url (str unpkg-dist-url "/oidc-client.min.js"))
   (sift :move {#"oidc-client.js"    "cljsjs/development/oidc-client.inc.js"
                #"oidc-client.min.js" "cljsjs/production/oidc-client.min.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :provides ["cljsjs.oidc-client"]
              :dependencies []
              :global-exports '{cljsjs.oidc-client Oidc})
   (pom)
   (jar)
   (validate)))
