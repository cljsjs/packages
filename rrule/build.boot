(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/rrule
       :version     +version+
       :description "JavaScript library for working with recurrence rules for calendar dates"
       :url         "https://github.com/jkbrzt/rrule"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://github.com/jkbrzt/rrule/blob/master/LICENCE"}})

(deftask package []
  (comp
   (download :url (str "https://raw.githubusercontent.com/jakubroztocil/rrule/v" +lib-version+ "/lib/rrule.js"))
   (sift :move {#"^rrule\.js" "cljsjs/rrule/development/rrule.inc.js"})
   (minify :in "cljsjs/rrule/development/rrule.inc.js"
           :out "cljsjs/rrule/production/rrule.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.rrule")))
