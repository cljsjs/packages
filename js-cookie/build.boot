(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/js-cookie
       :version     +version+
       :description "A simple, lightweight JavaScript API for handling browser cookies"
       :url         "https://github.com/js-cookie/js-cookie"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (str "https://github.com/js-cookie/js-cookie/releases/download/v" +lib-version+ "/js.cookie-" +lib-version+ ".min.js")
    :target "cljsjs/js-cookie/production/js-cookie.min.inc.js")
   (download
    :url (str "https://github.com/js-cookie/js-cookie/releases/download/v" +lib-version+ "/js.cookie-" +lib-version+ ".min.js")
    :target "cljsjs/js-cookie/development/js-cookie.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.js-cookie")
   (pom)
   (jar)
   (validate-checksums)))
