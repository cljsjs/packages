(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(def +lib-version+ "1.1.3")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project     'cljsjs/perspective-transform
       :version     +version+
       :description "A small JavaScript library for creating and applying perspective transforms."
       :url         "https://github.com/jlouthan/perspective-transform"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "http://raw.githubusercontent.com/jlouthan/perspective-transform/%s/dist/perspective-transform.js" +lib-version+)
              :checksum "4078724e1f627fe459be5bf2c0adb78a")
    (download :url (format "http://raw.githubusercontent.com/jlouthan/perspective-transform/%s/dist/perspective-transform.min.js" +lib-version+)
              :checksum "5e939de40c70c55df196d1e687bcd227")
    (sift :move {#"perspective-transform\.js" "cljsjs/development/perspective-transform.inc.js"
                 #"perspective-transform\.min\.js" "cljsjs/production/perspective-transform.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.perspective-transform")
    (pom)
    (jar)))
