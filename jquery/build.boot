(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(def +lib-version+ "3.2.1")
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
              :checksum "09DD64A64BA840C31A812A3CA25EAEEE")
    (download :url (format "http://code.jquery.com/jquery-%s.min.js" +lib-version+)
              :checksum "C9F5AEECA3AD37BF2AA006139B935F0A")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")
    (pom)
    (jar)))
