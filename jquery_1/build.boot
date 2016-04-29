(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(def +lib-version+ "1.12.2")
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
              :checksum "65A68381F99AD9484045173059524809")
    (download :url (format "http://code.jquery.com/jquery-%s.min.js" +lib-version+)
              :checksum "BDC2B7EFB1FAF219D65EDFE253A103E9")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")
    (pom)
    (jar)))
