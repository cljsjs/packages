(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def plottable-version "1.12.0")
(def +version+ (str plottable-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/plottable
       :version     +version+
       :description "Flexible, interactive charts for the web."
       :url         "http://plottablejs.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
         (comp
           (download :url "https://github.com/palantir/plottable/releases/download/v1.12.0/plottable.zip"
                     :checksum "f2c0ea46a93116b4d16393a703a286c5"
                     :unzip true)
           (sift :move {
                        #"plottable.js"     "cljsjs/plottable/development/plottable.inc.js"
                        #"plottable.min.js" "cljsjs/plottable/production/plottable.min.inc.js"
                        #"plottable.css"    "cljsjs/plottable/common/plottable.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.plottable"
                      :requires ["cljsjs.d3"])))