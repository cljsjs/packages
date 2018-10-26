(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])


(require '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.0.14")
(def +version+ (str +lib-version+ "-0"))


(task-options!
 pom {:project     'cljsjs/applicationinsights
      :version     +version+
      :scm         {:url "https://github.com/cljsjs/packages"}
      :description "Microsoft Application Insights JavaScript SDK"
      :url         "https://azure.microsoft.com/en-us/services/application-insights/"
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp
   (download :url (str "https://unpkg.com/applicationinsights-js@1.0.14/dist/ai.js")
             :target "cljsjs/applicationinsights/development/applicationinsights.inc.js")
   (download :url (str "https://unpkg.com/applicationinsights-js@1.0.14/dist/ai.0.js")
             :target "cljsjs/applicationinsights/production/applicationinsights.min.inc.js")
   (deps-cljs :provides ["applicationinsights" "cljsjs.applicationinsights"]
              :global-exports '{applicationinsights Microsoft})
   (pom)
   (jar)
   (validate-checksums)))
