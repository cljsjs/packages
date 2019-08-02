(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pixi-legacy
       :version     +version+
       :description "2D webGL renderer with canvas fallback (Legacy supports canvas renderer)"
       :url         "http://www.pixijs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (format "https://unpkg.com/pixi.js-legacy@%s/dist/pixi-legacy.min.js" +lib-version+)
    :target "cljsjs/pixi-legacy/production/pixi-legacy.min.inc.js")
   (download
    :url (format "https://unpkg.com/pixi.js-legacy@%s/dist/pixi-legacy.js" +lib-version+)
    :target "cljsjs/pixi-legacy/development/pixi-legacy.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi-legacy")
   (pom)
   (jar)
   (validate-checksums)))
