(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/liquidfun
       :version     +version+
       :description "Google's LiquidFun library for 2D physics simulation with particle systems."
       :url         "https://github.com/google/liquidfun"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://github.com/google/liquidfun/blob/master/liquidfun/Box2D/License.txt"}})

(deftask package []
  (comp
    (download ;:url (format "https://github.com/google/liquidfun/releases/download/v%s/liquidfun-%s.zip" +lib-version+ +lib-version+)
              ;:checksum "586683FDB306213E44BB81E7A6936086"
              ;:unzip true
              :url (format "https://raw.githubusercontent.com/google/liquidfun/v%s/liquidfun/Box2D/lfjs/liquidfun.js" +lib-version+)
              :checksum "DB619775261639461F33D1C41059A9B3")
    (show :fileset true)
    ;(sift :move {#"^liquidfun/Box2D/lfjs/liquidfun\.js" "cljsjs/liquidfun/common/liquidfun.inc.js"})
    (sift :move {#"^liquidfun\.js" "cljsjs/liquidfun/common/liquidfun.inc.js"})
    (sift :include #{#"^cljsjs/"})
    (deps-cljs :name "cljsjs.liquidfun")
    (pom)
    (jar)))
