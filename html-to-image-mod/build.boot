(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.11.11")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'io.github.cljsjs/html-to-image-mod
      :version     +version+
      :description "Generates an image from a DOM node using HTML5 canvas and SVG"
      :url         "https://github.com/bubkoo/html-to-image/"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*html-to-image.inc.js"     "cljsjs/html-to-image-mod/development/html-to-image-mod.inc.js"
                #".*html-to-image.min.inc.js" "cljsjs/html-to-image-mod/production/html-to-image-mod.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"html-to-image-mod.inc.js"
                              :file-min       #"html-to-image-mod.min.inc.js"
                              :provides       ["html-to-image-mod"
                                               "cljsjs.html-to-image-mod"]
                              :global-exports '{"html-to-image"              HtmlToImage}}]
              :externs [#"html-to-image-mod.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
