(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/jsqr
       :version     +version+
       :description "A pure javascript QR code reading library. This library takes in raw images and will locate, extract and parse any QR code found within."
       :url         "https://github.com/cozmo/jsQR"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/jsqr@" +lib-version+ "/dist/jsQR.js"))
    (sift :move {#"^jsQR\.js" "cljsjs/jsqr/development/jsqr.inc.js"})
    (minify :in "cljsjs/jsqr/development/jsqr.inc.js"
            :out "cljsjs/jsqr/production/jsqr.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jsqr")
    (validate-checksums)
    (pom)
    (jar)))
