(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/resumable.js
       :version     +version+
       :description "A JavaScript library for providing multiple simultaneous, stable, fault-tolerant and resumable/restartable uploads via the HTML5 File API"
       :url         "http://www.resumablejs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (format "https://raw.githubusercontent.com/23/resumable.js/v%s/resumable.js" +lib-version+)
    :target "cljsjs/resumable.js/production/resumable.js.min.inc.js")
   (download
    :url (format "https://raw.githubusercontent.com/23/resumable.js/v%s/resumable.js" +lib-version+)
    :target "cljsjs/resumable.js/development/resumable.js.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.resumable.js")
   (pom)
   (jar)
   (validate-checksums)))
