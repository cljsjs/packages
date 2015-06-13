(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def markdown-version "0.6.0-beta1")
(def +version+ (str markdown-version "-0"))

(task-options!
  pom  {:project     'cljsjs/markdown
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "A Markdown parser for javascript"
        :url         "https://github.com/evilstreak/markdown-js"
        :license     {"MIT" "http://www.opensource.org/licenses/mit-license.php"}})

(deftask package []
  (comp
    (download
      :url (str "https://github.com/evilstreak/markdown-js/releases/download/v"
             markdown-version "/markdown-browser-" markdown-version ".tgz")
      :decompress true
      :compression-format "gz"
      :archive-format "tar")
    (sift :move {#"^markdown-browser-.*/markdown\.js" "cljsjs/development/markdown.inc.js"
                 #"^markdown-browser-.*/markdown\.min\.js" "cljsjs/production/markdown.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.markdown")))
