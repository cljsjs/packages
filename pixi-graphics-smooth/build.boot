(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/pixi "7.2.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/pixi-graphics-smooth
       :version     +version+
       :description "Drop-in replacement for Graphics but with anti-aliasing"
       :url         "https://github.com/pixijs/graphics-smooth"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (format "https://unpkg.com/@pixi/graphics-smooth@%s/dist/pixi-graphics-smooth.js" +lib-version+)
    :target "cljsjs/pixi-graphics-smooth/production/pixi-graphics-smooth.min.inc.js")
   (download
    :url (format "https://unpkg.com/@pixi/graphics-smooth@%s/dist/pixi-graphics-smooth.js" +lib-version+)
    :target "cljsjs/pixi-graphics-smooth/development/pixi-graphics-smooth.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pixi-graphics-smooth")
   (pom)
   (jar)
   (validate-checksums)))
