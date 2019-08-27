(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(def +lib-version+ "3.4.0")
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
    (download :url (format "http://code.jquery.com/jquery-%s.js" +lib-version+))          
    (download :url (format "http://code.jquery.com/jquery-%s.min.js" +lib-version+))
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")
    (pom)
    (jar)
	(validate-checksums)))
