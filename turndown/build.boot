(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/turndown
       :version     +version+
       :description "Convert HTML into Markdown with JavaScript."
       :url         "https://github.com/domchristie/turndown"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/turndown@" +lib-version+ "/dist/turndown.js")
             :checksum "1B99DD6684BCFB09EC5910CC523ACF49")
   (sift :move {#"turndown.js"
                "cljsjs/turndown/development/turndown.inc.js"})
   (minify :in "cljsjs/turndown/development/turndown.inc.js"
           :out "cljsjs/turndown/production/turndown.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.turndown")
   (pom)
   (jar)))
