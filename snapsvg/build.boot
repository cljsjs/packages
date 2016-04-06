(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/snapsvg
       :version     +version+
       :description "The JavaScript SVG library for the modern web"
       :url         "https://snapsvg.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask download-snapsvg []
  (download :url      (str "https://github.com/adobe-webplatform/Snap.svg/archive/v" +lib-version+ ".zip")
            :checksum "faf20691a922b831fb6dce40e3ef4860"
            :unzip    true))

(deftask package []
  (comp
    (download-snapsvg)
    (sift :move {#"^Snap.svg-.*/dist/snap.svg.js"
                 "cljsjs/snapsvg/development/snapsvg.inc.js"
                 #"^Snap.svg-.*/dist/snap.svg-min.js"
                 "cljsjs/snapsvg/production/snapsvg.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.snapsvg")
    (pom)
    (jar)))
