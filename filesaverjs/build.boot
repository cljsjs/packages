(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "1.20150507.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/filesaverjs
       :version     +version+
       :description "An HTML5 saveAs() FileSaver implementation"
       :url         "https://github.com/Teleborder/FileSaver.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/Teleborder/FileSaver.js"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/Teleborder/FileSaver.js/archive/v" +lib-version+ ".zip")
             :checksum "2e945d8a90d81f8c5f3619a0ca1c5fda"
             :unzip true)
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.js" "cljsjs/filesaverjs/development/filesaverjs.inc.js"})
   (sift :move {#"^FileSaver.js-[^/]+/FileSaver.min.js" "cljsjs/filesaverjs/development/filesaverjs.min.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filesaverjs")))
