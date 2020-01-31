(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))
(def +source-url+ "https://unpkg.com/codeflask/build/codeflask.min.js")

(task-options!
 pom  {:project     'cljsjs/codeflask
       :version     +version+
       :description "A micro code-editor for awesome web pages"
       :url         "https://github.com/kazzkiq/CodeFlask"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/mit-license.php"}})

(deftask package []
  (comp
    (download :url +source-url+ :target "cljsjs/codeflask/production/codeflask.inc.js")
    (download :url +source-url+ :target "cljsjs/codeflask/development/codeflask.inc.js")
    (deps-cljs :provides ["cljsjs.codeflask"] :global-exports '{cljsjs.codeflask CodeFlask})
    (pom) 
    (jar)
    (validate)))
