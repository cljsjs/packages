(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2017.09.21")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/google-analytics
       :version     +version+
       :description "Google Universal Analytics (analytics.js)"
       :url         "https://developers.google.com/analytics/devguides/collection/analyticsjs/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url "https://www.google-analytics.com/analytics.js"
              :checksum "0EA40A4CB2873A89CBE597EAEA860826")
    (sift :move {#"analytics.js" "cljsjs/google-analytics/production/google-analytics.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.google-analytics")
    (pom)
    (jar)))
