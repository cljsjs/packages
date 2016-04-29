(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project     'cljsjs/nprogress
       :version     +version+
       :description "Slim progress bars for Ajax'y applications. Inspired by Google, YouTube, and Medium."
       :url         "http://ricostacruz.com/nprogress"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
         (comp
           (download :url (format "https://github.com/rstacruz/nprogress/archive/v%s.zip" +lib-version+)
                     :checksum "274ebe53662ec0a9ba76d44c89d010cb"
                     :unzip true)
           (sift :move {
                        #"^nprogress-\d.\d.\d/nprogress.js$"  "cljsjs/nprogress/development/nprogress.inc.js"
                        #"^nprogress-\d.\d.\d/nprogress.css$" "cljsjs/nprogress/common/nprogress.css"})
           (minify :in "cljsjs/nprogress/development/nprogress.inc.js" :out "cljsjs/nprogress/production/nprogress.min.inc.js")
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.nprogress")
           (pom)
           (jar)))
