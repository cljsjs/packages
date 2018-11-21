(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/d3 "4.3.0-5"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3-horizon-chart
       :version     +version+
       :description "D3 plug-in that draws horizon charts using canvas."
       :url         "http://kmandov.github.io/d3-horizon-chart/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://npmcdn.com/d3-horizon-chart@" +lib-version+ "/build/d3-horizon-chart.js")
             :checksum "077d1a3811087622f2c2e4c25442af22")
   (sift :move {#"^d3-horizon-chart\.js"      "cljsjs/d3-horizon-chart/development/d3-horizon-chart.inc.js"})
   (minify    :in       "cljsjs/d3-horizon-chart/development/d3-horizon-chart.inc.js"
              :out      "cljsjs/d3-horizon-chart/production/d3-horizon-chart.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-horizon-chart"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))