(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/seedrandom
       :version     +version+
       :description "seeded random number generator for Javascript"
       :url         "https://github.com/davidbau/seedrandom"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/seedrandom/%s/seedrandom.js"
                          +lib-version+)
             :checksum "762146EBDD39C75237DC1EF2BAA46FEB")

   (replace-content :in "seedrandom.js" :out "seedrandom.inc.js"
                    :match #"module.exports = .*;"
                    :value "")

   (sift :move {#"^seedrandom.inc.js$" "cljsjs/seedrandom/development/seedrandom.inc.js"})

   (minify :in  "cljsjs/seedrandom/development/seedrandom.inc.js"
           :out "cljsjs/seedrandom/production/seedrandom.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.seedrandom")
   (pom)
   (jar)))
