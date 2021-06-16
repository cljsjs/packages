(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/chartjs
       :version +version+
       :description "Chart.js - Simple yet flexible JavaScript charting for designers & developers
"
       :url "http://www.chartjs.org/"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://unpkg.com/chart.js@"
       +lib-version+
       "/dist/"
       file))

(deftask package []
  (comp
    (download :url (cdn-ver "chart.js"))
    (download :url (cdn-ver "chart.min.js"))
    (sift :move
          {#"chart.js" "cljsjs/chartjs/development/chart.inc.js"
           #"chart.min.js" "cljsjs/chartjs/production/chart.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chartjs")
    (pom)
    (jar)
    (validate)))
