(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.9.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/jstat
       :version     +version+
       :description "JavaScript Statistical Library"
       :url         "https://github.com/jstat/jstat"
       :scm         {:url "https://github.com/jstat/jstat"}
       :license     {"MIT" "https://github.com/jstat/jstat/blob/1.x/LICENSE"}})

(deftask package []
  (comp
   (download :url (format "https://cdn.jsdelivr.net/npm/jstat@%s/dist/jstat.js" +lib-version+)
             :target "cljsjs/jstat/development/jstat.inc.js")
   (download :url (format "https://cdn.jsdelivr.net/npm/jstat@%s/dist/jstat.min.js" +lib-version+)
             :target "cljsjs/jstat/production/jstat.min.inc.js")
   (deps-cljs :provides ["jstat" "cljsjs.jstat"]
              :requires []
              :global-exports '{jstat jStat})
   (pom :project 'cljsjs/jstat
        :dependencies [])
   (show :fileset true)
   (jar)
   (validate)))
