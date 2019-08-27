(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.11.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/simplemde
      :version     +version+
      :description "A drop-in JavaScript textarea replacement for writing beautiful and understandable Markdown"
      :url         "https://simplemde.com/"
      :scm         {:url "https://github.com/NextStepWebs/simplemde-markdown-editor"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/NextStepWebs/simplemde-markdown-editor/archive/%s.zip" +lib-version+)
              :checksum "340E2951EDE4A576DFE5B6BB735FC3CD"
              :unzip    true)
   (sift      :move     {#"^simplemde.*/debug/simplemde\.js$"    "cljsjs/simplemde/development/simplemde.inc.js"
                         #"^simplemde.*/debug/simplemde\.css$"   "cljsjs/simplemde/development/simplemde.css"

                         #"^simplemde.*/dist/simplemde\.min\.js$"    "cljsjs/simplemde/production/simplemde.min.inc.js"
                         #"^simplemde.*/dist/simplemde\.min\.css$"   "cljsjs/simplemde/production/simplemde.min.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.simplemde")
   (pom)
   (jar)))
