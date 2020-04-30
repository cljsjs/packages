(set-env!
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.0") 
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/js-joda-timezone
       :version     +version+
       :description "timezone extensions for js-joda"
       :url         "https://js-joda.github.io/js-joda/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/js-joda/js-joda/archive/@js-joda/timezone@%s.zip" +lib-version+)
                :unzip true)
    
    (sift :move {#"^js-joda--js-joda-timezone-([\d\.]+)/packages/timezone/dist/js-joda-timezone\.js$" "cljsjs/js-joda-timezone/development/js-joda-timezone.inc.js"})
    (minify :in  "cljsjs/js-joda-timezone/development/js-joda-timezone.inc.js"       
            :out "cljsjs/js-joda-timezone/production/js-joda-timezone.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs 
      :no-externs true 
      :provides ["@js-joda/timezone"]
      :requires ["@js-joda/core"])
    (pom)
    (jar)))
