(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/markdown-it
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "Markdown parser, done right. 100% CommonMark support, extensions, syntax plugins & high speed"
        :url         "https://markdown-it.github.io/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/markdown-it/markdown-it/archive/%s.zip" +lib-version+)
              :checksum "0E769078064235A0776B7366F4E0BDE8"
              :unzip    true)
   (sift      :move     {#"^markdown-it.*[/ \\]dist[/ \\]markdown-it.js$"
                         "cljsjs/markdown-it/development/markdown-it.inc.js"
                         #"^markdown-it.*[/ \\]dist[/ \\]markdown-it.min.js"
                         "cljsjs/markdown-it/production/markdown-it.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.markdown-it")
   (pom)
   (jar)))
