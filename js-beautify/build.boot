(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.8")
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
             :checksum "b0b6d79bbd801b2742a26e2e35b4138a"
             :unzip true)
   (sift :move {#"^js-beautify-([\d\.]+)/js/lib/beautify\.js$" "cljsjs/js-beautify/development/beautify.inc.js"
                #"^js-beautify-([\d\.]+)/js/lib/beautify-html\.js$" "cljsjs/js-beautify/development/beautify-html.inc.js"
                #"^js-beautify-([\d\.]+)/js/lib/beautify-css\.js$" "cljsjs/js-beautify/development/beautify-css.inc.js"})
   (minify :in "cljsjs/js-beautify/development/beautify.inc.js"
           :out "cljsjs/js-beautify/production/beautify.min.inc.js"
           :lang :ecmascript5)
   (minify :in "cljsjs/js-beautify/development/beautify-html.inc.js"
           :out "cljsjs/js-beautify/production/beautify-html.min.inc.js"
           :lang :ecmascript5)
   (minify :in "cljsjs/js-beautify/development/beautify-css.inc.js"
           :out "cljsjs/js-beautify/production/beautify-css.min.inc.js"
           :lang :ecmascript5)
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (pom)
   (jar)))
