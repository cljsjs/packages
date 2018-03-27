(def +lib-version+ "2.19.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/mixpanel
       :version     +version+
       :description "Deeply understand every user's journey with instant insights for everyone on mobile and web."
       :url         "https://mixpanel.com"
       :scm         {:url "https://github.com/mixpanel/mixpanel-js"}
       :license     {"Apache 2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package  []
  (comp
   (download :url (str "https://unpkg.com/mixpanel-browser@" +lib-version+  "/build/mixpanel.umd.js"))
   (download :url (str "https://unpkg.com/mixpanel-browser@" +lib-version+  "/mixpanel.min.js"))
   (sift :move {#"^mixpanel.umd.js$"
                "cljsjs/mixpanel/development/mixpanel.inc.js"
                #"^mixpanel.min.js"
                "cljsjs/mixpanel/production/mixpanel.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.mixpanel")
   (pom)
   (jar)
   (validate-checksums)))
