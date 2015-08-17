(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.3.5")
(bootlaces! +version+)

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/marked
        :version     +version+
        :description "A markdown parser and compiler. Built for speed."
        :url         "https://github.com/chjj/marked"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url "https://github.com/chjj/marked/archive/v0.3.5.zip"
              :checksum "989c318bc90eddad1182dd7268d2ab72"
              :unzip true)
    (sift :move {#"^marked-(.*)/lib/marked\.js"  "cljsjs/development/marked.inc.js"
                 #"^marked-(.*)/marked\.min\.js" "cljsjs/production/marked.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.marked")))
