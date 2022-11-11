(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "20.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project 'io.github.cljsjs/keycloak-js
       :version +version+
       :description ""
       :url "https://github.com/keycloak/keycloak"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"Apache-2.0" "https://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url      (str "https://unpkg.com/keycloak-js@" +lib-version+ "/dist/keycloak.js")
             :target   "cljsjs/keycloak-js/development/keycloak-js.inc.js")
   (download :url      (str "https://unpkg.com/keycloak-js@" +lib-version+ "/dist/keycloak.min.js")
             :target   "cljsjs/keycloak-js/production/keycloak-js.min.inc.js")
   (deps-cljs :provides ["cljsjs.keycloak-js" "keycloak-js"])
   (pom)
   (jar)
   (validate)))
