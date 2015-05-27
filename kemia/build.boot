(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.2.0")

(task-options!
 pom  {:project     'cljsjs/kemia
       :version     +version+
       :description "A chemical structure library"
       :url         "http://kemia.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache" "http://www.apache.org/licenses/"}})

(deftask package []
  (comp
    (download :url "https://github.com/kemia/kemia/archive/v0.2.zip"
              :checksum "DED3B45E53C56188758F964EDAB08344"
              :unzip true)
    (sift :move {#"^kemia-([\d\.]*)/kemia/" "cljsjs/kemia/development/"
                 #"^kemia-([\d\.]*)/css/kemia.css" "cljsjs/kemia/common/kemia.inc.css"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})))

