(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.12.0")
(def +version+ (str +lib-version+ "-0"))

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
           (download :url (format "https://github.com/palantir/plottable/releases/download/v%s/plottable.zip" +lib-version+)
                     :checksum "f2c0ea46a93116b4d16393a703a286c5"
                     :unzip true)
           (sift :move {
                        #"plottable.js"     "cljsjs/plottable/development/plottable.inc.js"
                        #"plottable.min.js" "cljsjs/plottable/production/plottable.min.inc.js"
                        #"plottable.css"    "cljsjs/plottable/common/plottable.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.plottable"
                      :requires ["cljsjs.d3"])
           (pom)
           (jar)))
