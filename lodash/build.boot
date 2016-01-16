(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.10.1")
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
    (download :url (format "https://raw.github.com/lodash/lodash/%s/lodash.js" +lib-version+)
              :checksum "a418b0a0b840542a0f47af6af7b7a025")
    (download :url (format "https://raw.github.com/lodash/lodash/%s/lodash.min.js" +lib-version+)
              :checksum "7629cac4f079926ef505e2271bb5135f")
    (sift :move {#"lodash\.js" "cljsjs/lodash/development/lodash.inc.js"
                 #"lodash\.min\.js" "cljsjs/lodash/production/lodash.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.lodash")))
