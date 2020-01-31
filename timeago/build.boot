(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/timeago
       :version     +version+
       :description "timeago.js is a simple library (less than 2 kb) that is used to format datetime with *** time ago statement. eg: '3 hours ago'."
       :url         "https://github.com/hustcc/timeago.js"
       :scm         {:url "https://github.com/hustcc/timeago.js"}
       :license     {"MIT" "https://github.com/hustcc/timeago.js/blob/master/LICENSE"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/hustcc/timeago.js/archive/v%s.zip" +lib-version+)
              :checksum "1135A95C5FB995291A684F52F2BD2315"
              :unzip true)
    (sift :move {#"^timeago.*/dist/timeago\.js" "cljsjs/timeago/development/timeago.inc.js"
                 #"^timeago.*/dist/timeago\.min\.js" "cljsjs/timeago/production/timeago.min.inc.js"
                 #"^timeago.*/dist/timeago\.locales\.min\.js" "cljsjs/timeago/production/timeago.locales.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.timeago")
    (pom)
    (jar)))

