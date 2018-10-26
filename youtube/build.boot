(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/youtube
       :version     +version+
       :description "YouTube.com Javascript SDK"
       :url         "https://developers.google.com/youtube/iframe_api_reference"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"YouTube ToS" "https://developers.google.com/site-terms/"}})

(deftask package []
  (comp
    (pom)
    (jar)
    (validate)))
