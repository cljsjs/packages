(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/js-beautify
       :version     +version+
       :description "Beautifier for javascript"
       :url         "http://jsbeautifier.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/beautify-web/js-beautify/archive/v%s.zip" +lib-version+)
              :checksum "d5baf366068832ceee28ef3e6ae9d523"
              :unzip true)
    (sift :move {#"^js-beautify-([\d\.]+)/js/lib/beautify\.js$" "cljsjs/js-beautify/development/beautify.inc.js"})
    (minify :in "cljsjs/js-beautify/development/beautify.inc.js"
            :out "cljsjs/js-beautify/production/beautify.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.js-beautify")
    (pom)
    (jar)))
