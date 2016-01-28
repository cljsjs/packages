(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-checkout+ "230de7d1426d0d04abe782e0aed5800838892dd7")
(def +lib-version+ "1.1.20151003")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/filesaverjs
       :version     +version+
       :description "An HTML5 saveAs() FileSaver implementation"
       :url         "https://github.com/eligrey/FileSaver.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/eligrey/FileSaver.js"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/eligrey/FileSaver.js/archive/" +lib-checkout+ ".zip")
             :checksum "02220c6a058b03a8270c1e481b440a23"
             :unzip true)
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.js" "cljsjs/filesaverjs/development/filesaverjs.inc.js"})
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.min.js" "cljsjs/filesaverjs/development/filesaverjs.min.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filesaverjs")))
