(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/pixi "4.8.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pixi-viewport
       :version     +version+
       :description "A highly configurable viewport/2D camera designed to work with pixi.js"
       :url         "https://github.com/davidfig/pixi-viewport"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (format "https://github.com/davidfig/pixi-viewport/releases/download/%s/pixi-viewport.min.js" +lib-version+)
      :target "cljsjs/pixi-viewport/production/pixi-viewport.min.inc.js")
    (download
      :url (format "https://github.com/davidfig/pixi-viewport/releases/download/%s/pixi-viewport.js" +lib-version+)
      :target "cljsjs/pixi-viewport/development/pixi-viewport.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pixi-viewport"
               :requires ["cljsjs.pixi"])
    (pom)
    (jar)
    (validate-checksums)))
