(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/chance
       :version     +version+
       :description "Chance is a minimalist generator of random strings, numbers, etc"
       :url         "http://chancejs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "http://chancejs.com/chance-" +lib-version+ ".js")
              :checksum "1ba2c414dabb25fdd5a078622748935d")
    (download :url (str "http://chancejs.com/chance-" +lib-version+ ".min.js")
              :checksum "6626802c618649c394f817e5142bb4b1")
    (sift :move {#"chance-([\d\.]*).js" "cljsjs/development/chance.inc.js"
                 #"chance-([\d\.]*).min.js" "cljsjs/production/chance.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chance")
    (pom)
    (jar)))
