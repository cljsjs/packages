(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-checkout+ "f23c4a66dc9fa1af818322f08eb29a371ccb4ccf")
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
             :checksum "45a874d19c911acdcdafea9a0246ea3c"
             :unzip true)
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.js" "cljsjs/filesaverjs/development/filesaverjs.inc.js"})
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.min.js" "cljsjs/filesaverjs/development/filesaverjs.min.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filesaverjs")))
