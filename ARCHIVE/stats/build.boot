(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16")
(def +version+ (str +lib-version+ ".0-0"))

(task-options!
 pom  {:project     'cljsjs/stats
       :version     +version+
       :description "JavaScript Performance Monitor."
       :url         "https://github.com/mrdoob/stats.js"
       :scm         {:url "https://github.com/mrdoob/stats.js"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/mrdoob/stats.js/archive/r%s.zip" +lib-version+)
              :checksum "8e94114d395e4adc8b273e5094aa7f54"
              :unzip true)
    (sift :move {#"^stats.*/src/Stats\.js" "cljsjs/stats/development/stats.inc.js"
                 #"^stats.*/build/stats\.min\.js" "cljsjs/stats/production/stats.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.stats")
    (pom)
    (jar)))
