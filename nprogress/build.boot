(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def nprogress-version "0.2.0")
(def +version+ (str nprogress-version "-1"))
(bootlaces! +version+)

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
           (download :url "https://github.com/rstacruz/nprogress/archive/v0.2.0.zip"
                     :checksum "274ebe53662ec0a9ba76d44c89d010cb"
                     :unzip true)
           (sift :move {
                        #"^nprogress-\d.\d.\d/nprogress.js$"  "cljsjs/nprogress/development/nprogress.inc.js"
                        #"^nprogress-\d.\d.\d/nprogress.css$" "cljsjs/nprogress/common/nprogress.css"})
           (minify :in "cljsjs/nprogress/development/nprogress.inc.js" :out "cljsjs/nprogress/production/nprogress.min.inc.js")
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.nprogress")))