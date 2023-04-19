(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "15.4.2-2"]
                  [cljsjs/chartjs "2.7.3-0"]])

(require '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :as util]
         '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[clojure.java.io :as io])

(def +lib-version+ "2.7.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/react-chartjs-2
       :version     +version+
       :description "React wrapper for Chart.js"
       :url         "http://jerairrest.github.io/react-chartjs-2/"
       :scm         {:url "https://github.com/jerairrest/react-chartjs-2"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-chartjs-2@%s/dist/react-chartjs-2.js" +lib-version+))
   (download :url (format "https://unpkg.com/react-chartjs-2@%s/dist/react-chartjs-2.min.js" +lib-version+))
   (sift :move {#"^react-chartjs-2\.js"      "cljsjs/react-chartjs-2/development/react-chartjs-2.inc.js"
                #"^react-chartjs-2\.min\.js" "cljsjs/react-chartjs-2/production/react-chartjs-2.min.inc.js"})
   (deps-cljs :name "cljsjs.react-chartjs-2" :requires ["cljsjs.chartjs" "cljsjs.react" "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
