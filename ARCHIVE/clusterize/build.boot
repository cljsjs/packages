(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.16.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/clusterize
       :version +version+
       :description "Clusterize.js - Tiny vanilla JS plugin to display large data sets easily"
       :url "https://clusterize.js.org/"
       :license {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/NeXTs/Clusterize.js/archive/v%s.zip" +lib-version+)
                     :unzip true)
           (sift :move {#".*clusterize\.js"        "cljsjs/clusterize/development/clusterize.inc.js"
                        #".*clusterize\.min\.js"   "cljsjs/clusterize/production/clusterize.min.inc.js"})
           (show :fileset true)
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.clusterize")
           (pom)
           (jar)))
