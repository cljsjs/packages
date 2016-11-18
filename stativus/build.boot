(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/stativus
       :version     +version+
       :description "A Statechart library"
       :url         "https://github.com/etgryphon/stativus"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url "https://github.com/etgryphon/stativus/archive/0.10.0.zip"
             :checksum "B9F9343113D1DB540EAA2F162377A26B"
             :unzip true)
   (sift :move {#"^stativus\-master\/stativus\.js"      "cljsjs/stativus/development/stativus.inc.js"
                #"^stativus\-master\/libs\/stativus\-min\.js" "cljsjs/stativus/production/stativus.min.inc.js"})
   (show :fileset true )
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.stativus")
   (pom)
   (jar)))
