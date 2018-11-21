(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "1.3.3")
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
   (download :url (str "https://github.com/eligrey/FileSaver.js/archive/" +lib-version+ ".zip")
             :checksum "4c272da9dd9658cdea7101efb942db81"
             :unzip true)
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.js" "cljsjs/filesaverjs/development/filesaverjs.inc.js"})
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.min.js" "cljsjs/filesaverjs/development/filesaverjs.min.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filesaverjs")
   (pom)
   (jar)))
