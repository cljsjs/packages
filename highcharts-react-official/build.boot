(def +lib-version+ "3.0.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/highcharts "7.0.3-0"]
                  [cljsjs/react "16.9.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/highcharts-react-official
       :version     +version+
       :description "Official minimal Highcharts wrapper for React."
       :url         "https://github.com/highcharts/highcharts-react"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/highcharts-react-official@%s/dist/highcharts-react.js" +lib-version+)
             :target "cljsjs/highcharts-react-official/development/highcharts-react.inc.js")
   (download :url (format "https://unpkg.com/highcharts-react-official@%s/dist/highcharts-react.min.js" +lib-version+)
             :target "cljsjs/highcharts-react-official/production/highcharts-react.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highcharts-react-official"
              :requires ["cljsjs.react" "cljsjs.highcharts"])
   (pom)
   (jar)
   (validate)))
