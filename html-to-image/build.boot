(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.10.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'io.github.cljsjs/html-to-image
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
   (sift :move {#".*html-to-image.inc.js"     "cljsjs/html-to-image/development/html-to-image.inc.js"
                #".*html-to-image.min.inc.js" "cljsjs/html-to-image/production/html-to-image.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"html-to-image.inc.js"
                              :file-min       #"html-to-image.min.inc.js"
                              :provides       ["html-to-image"
                                               "cljsjs.html-to-image"]
                              :global-exports '{"html-to-image"              HtmlToImage}}]
              :externs [#"html-to-image.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
