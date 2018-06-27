(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/js-joda-locale-en-us
       :version     +version+
       :description "prebuilt en-US locale addon for js-joda"
       :url         "https://js-joda.github.io/js-joda/js-joda-locale"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/js-joda/js-joda-locale/8e384141cb191c8cbf35b2844cab15ace035f806/packages/en-us/dist/index.js" ))
    (sift :move {#"^index\.js$" "cljsjs/js-joda-locale-en-us/development/js-joda-locale-en-us.inc.js"})
    
    (minify :in  "cljsjs/js-joda-locale-en-us/development/js-joda-locale-en-us.inc.js"
            :out "cljsjs/js-joda-locale-en-us/production/js-joda-locale-en-us.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs 
      :name "cljsjs.js-joda-locale-en-us" 
      :requires ["cljsjs.js-joda" "cljsjs.js-joda-timezone"])
    (pom)
    (jar)))
