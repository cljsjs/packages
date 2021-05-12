(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/chartjs "3.2.0-0"]
                  [cljsjs/date-fns "2.20.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'io.github.cljsjs/chartjs-adapter-date-fns
       :version +version+
       :description "This adapter allows the use of date-fns with Chart.js."
       :url "https://github.com/chartjs/chartjs-adapter-date-fns"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@"
       +lib-version+
       "/dist/"
       file))

(deftask package []
  (comp
    (download :url (cdn-ver "chartjs-adapter-date-fns.js"))
    (download :url (cdn-ver "chartjs-adapter-date-fns.min.js"))
    (sift :move
          {#"chartjs-adapter-date-fns.js" "cljsjs/chartjs-adapter-date-fns/development/chartjs-adapter-date-fns.inc.js"
           #"chartjs-adapter-date-fns.min.js" "cljsjs/chartjs-adapter-date-fns/production/chartjs-adapter-date-fns.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chartjs-adapter-date-fns"
               :requires ["cljsjs.chartjs" "cljsjs.date-fns"])
    (pom)
    (jar)
    (validate)))
