(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

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
    (deps-cljs :name "cljsjs.markdown")
    (sift :include #{#"^cljsjs" #"^deps\.cljs$"})))
