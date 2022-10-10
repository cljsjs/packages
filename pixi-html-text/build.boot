(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/pixi-html-text
       :version     +version+
       :description "An alternative to PIXI.Text that works with PixiJS v5 (both WebGL and Canvas)"
       :url         "https://github.com/pixijs/html-text"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (format "https://github.com/pixijs/html-text/releases/download/v%s/html-text.js" +lib-version+)
    :target "cljsjs/pixi-html-text/production/pixi-html-text.min.inc.js")
   (download
    :url (format "https://github.com/pixijs/html-text/releases/download/v%s/html-text.js" +lib-version+)
    :target "cljsjs/pixi-html-text/development/pixi-html-text.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi-html-text"
              :requires ["cljsjs.pixi"])
   (pom)
   (jar)
   (validate-checksums)))
