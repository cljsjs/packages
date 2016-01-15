(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/lunrjs
       :version     +version+
       :description "Lunr.js is a small, full-text search library for
       use in the browser. It indexes JSON documents and provides a
       simple search interface for retrieving documents that best
       match text queries."
       :url         "http://github.com/olivernn/lunr.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (str "https://github.com/olivernn/lunr.js/archive/v" +lib-version+ ".zip")
             :checksum "f5e654f5d8980037e6473976e35515b4"
             :unzip    true)
   (sift :move {#"lunr\.js-\d+\.\d+\.\d+/lunr\.js$"      "cljsjs/lunrjs/development/lunrjs.inc.js"
                #"lunr\.js-\d+\.\d+\.\d+/lunr\.min\.js$" "cljsjs/lunrjs/production/lunrjs.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.lunrjs")))
