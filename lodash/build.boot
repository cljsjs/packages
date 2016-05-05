(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.11.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/lodash
       :version     +version+
       :description "A JavaScript utility library delivering consistency, modularity, performance, & extras."
       :url         "https://lodash.com/"
       :scm         {:url "https://github.com/lodash/lodash"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/lodash/lodash/archive/%s.zip" +lib-version+)
              :checksum "98bb28466361694122ff65384b4f1f08"
              :unzip    true)
   (sift      :move     {#"^lodash(.*)/dist/lodash.js"
                         "cljsjs/lodash/development/lodash.inc.js"
                         #"^lodash(.*)/dist/lodash.min.js"
                         "cljsjs/lodash/production/lodash.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.lodash")
   (pom)
   (jar)))
