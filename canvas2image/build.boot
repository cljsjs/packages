(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/canvas2image
       :version +version+
       :description "canvas2image - a tool of saving or converting canvas to images"
       :url "https://github.com/hongru/canvas2image"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/hongru/canvas2image/8a5394679fe8078e823a2347edf581d3cb26fab2/canvas2image.js")
    (sift :move
          {#"canvas2image.js" "cljsjs/canvas2image/development/canvas2image.inc.js"
           #"canvas2image.js" "cljsjs/canvas2image/production/canvas2image.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.canvas2image")
    (pom)
    (jar)))
