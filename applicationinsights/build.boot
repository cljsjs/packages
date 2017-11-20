(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.2" :scope "test"]])

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
   (download :url (str "https://github.com/Microsoft/ApplicationInsights-JS/archive/master.zip")
             :unzip true)
   (sift :move {(re-pattern (str "ApplicationInsights-JS-master/dist/ai.js"))   "cljsjs/development/applicationinsights.inc.js"
                (re-pattern (str "ApplicationInsights-JS-master/dist/ai.0.js")) "cljsjs/production/applicationinsights.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.applicationinsights")
   (pom)
   (jar)
   (validate-checksums)))
