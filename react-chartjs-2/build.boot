(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react "15.4.2-2"]
                  [cljsjs/chartjs "2.5.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/react-chartjs-2
       :version     +version+
       :description "React wrapper for Chart.js"
       :url         "http://gor181.github.io/react-chartjs-2/"
       :scm         {:url "https://github.com/gor181/react-chartjs-2"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/gor181/react-chartjs-2/archive/%s.zip" +lib-version+) :unzip true)
           (sift :move {#"^react-chartjs.*\/dist\/react-chartjs-2\.js"      "cljsjs/react-chartjs-2/development/react-chartjs-2.inc.js"
                        #"^react-chartjs.*\/dist\/react-chartjs-2\.min\.js" "cljsjs/react-chartjs-2/production/react-chartjs-2.min.inc.js"})
           (show :fileset true)
           (deps-cljs :name "cljsjs.react-chartjs-2" :requires ["cljsjs.chartjs" "cljsjs.react"])
           (pom)
           (jar)))
