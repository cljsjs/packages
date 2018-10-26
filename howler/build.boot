(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/howler
       :version     +version+
       :description "Javascript audio library for the modern web."
       :url         "https://howlerjs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/howler@%s/dist/howler.js" +lib-version+)
             :target "cljsjs/howler/development/howler.inc.js")
   (download :url (format "https://unpkg.com/howler@%s/dist/howler.min.js" +lib-version+)
             :target "cljsjs/howler/production/howler.min.inc.js")
   (deps-cljs :name "cljsjs.howler")
   (pom)
   (jar)
   (validate-checksums)))
