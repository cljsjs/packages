(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(def +lib-version+ "2.2.2")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project     'cljsjs/jquery
       :version     +version+
       :description "The Write Less, Do More, JavaScript Library."
       :url         "http://jquery.com/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "http://code.jquery.com/jquery-%s.js" +lib-version+)
              :checksum "C2E3D53624F901F3F15AE4D03B098EEF")
    (download :url (format "http://code.jquery.com/jquery-%s.min.js" +lib-version+)
              :checksum "1D35678C5EDBB639AB7AA5CCE0856F57")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")
    (pom)
    (jar)))
