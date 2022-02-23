(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.1")
(def +version+ (str +lib-version+ "-0"))

(def unpkg-dist-url (str "https://unpkg.com/oidc-client-ts@" +lib-version+ "/dist/browser/"))

(task-options!
 pom  {:project     'io.github.cljsjs/oidc-client-ts
       :version     +version+
       :description "OpenID Connect (OIDC) and OAuth2 protocol support for browser-based JavaScript applications"
       :url         "https://github.com/authts/oidc-client-ts"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str unpkg-dist-url "/oidc-client-ts.js"))
   (download :url (str unpkg-dist-url "/oidc-client-ts.min.js"))
   (sift :move {#"oidc-client-ts.js"    "cljsjs/development/oidc-client-ts.inc.js"
                #"oidc-client-ts.min.js" "cljsjs/production/oidc-client-ts.min.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :provides ["cljsjs.oidc-client-ts"]
              :global-exports '{cljsjs.oidc-client-ts oidc})
   (pom)
   (jar)
   (validate)))
