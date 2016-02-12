(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2015.04.13")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/google-analytics
       :version     +version+
       :description "Google Universal Analytics (analytics.js)"
       :url         "https://developers.google.com/analytics/devguides/collection/analyticsjs/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"" ""}})

(deftask package []
  (comp
    (download :url "https://www.google-analytics.com/analytics.js"
              :checksum "eed8ec65a6dd9b05eed6d4a02e1439e4")
    (sift :move {#"analytics.js" "cljsjs/google-analytics/production/google-analytics.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.google-analytics")))
