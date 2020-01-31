(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pixi
       :version     +version+
       :description "2D webGL renderer with canvas fallback"
       :url         "http://www.pixijs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (format "https://pixijs.download/v%s/pixi.min.js" +lib-version+)
    :target "cljsjs/pixi/production/pixi.min.inc.js")
   (download
    :url (format "https://pixijs.download/v%s/pixi.js" +lib-version+)
    :target "cljsjs/pixi/development/pixi.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi")
   (pom)
   (jar)
   (validate-checksums)))
