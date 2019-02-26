(def +lib-version+ "0.9.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])


(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/katex
       :version     +version+
       :description "A fast, easy-to-use JavaScript library for TeX math rendering on the web."
       :url         "https://khan.github.io/KaTeX/"
       :scm         {:url "https://github.com/Khan/KaTeX"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (comp
   (download :url (str "https://github.com/Khan/KaTeX/releases/download/v" +lib-version+ "/katex.zip")
             :unzip true)
   (sift :move {#"^katex/katex.js$"
                "cljsjs/katex/development/katex.inc.js"
                #"^katex/katex.css$"
                "cljsjs/katex/development/katex.inc.css"
                #"^katex/katex.min.js"
                "cljsjs/katex/production/katex.min.inc.js"
                #"katex/katex.min.css"
                "cljsjs/katex/production/katex.min.inc.css"
                #"^katex/fonts/(.*)"
                "cljsjs/katex/common/fonts/$1"})
   (sift :include #{#"^cljsjs"})
   (show :fileset true)
   (deps-cljs :name "cljsjs.katex")
   (pom)
   (jar)
   (validate)))
