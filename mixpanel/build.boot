(def +lib-version+ "2.22.4")
(def +version+ (str +lib-version+ "-1"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

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
   (download :url (format "https://unpkg.com/mixpanel-browser@%s/build/mixpanel.umd.js" +lib-version+)
             :target "cljsjs/mixpanel/development/mixpanel.inc.js")
   (download :url (format "https://unpkg.com/mixpanel-browser@%s/mixpanel.min.js" +lib-version+)
             :target "cljsjs/mixpanel/production/mixpanel.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.mixpanel")
   (pom)
   (jar)
   (validate)))
