(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/vega "4.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.14.0")

(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/vega-tooltip
       :version     +version+
       :description "Tooltip Plugin for Vega-Lite."
       :url         "https://vega.github.io/vega-tooltip/"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/build/vega-tooltip.js" +lib-version+)
     :checksum "DE0BA99833B78D7426F78A5B10625B51")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/build/vega-tooltip.min.js" +lib-version+)
     :checksum "C1A6E71B931B718D2A7ACEBE0D5071BD")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/vega-tooltip.css" +lib-version+)
     :checksum "ca9dc27595bbadc7048370ee79fabb8d")
    (sift :move {#".*vega-tooltip\.js$"      "cljsjs/vega-tooltip/development/vega-tooltip.inc.js"})
    (sift :move {#".*vega-tooltip\.min\.js$" "cljsjs/vega-tooltip/production/vega-tooltip.min.inc.js"})
    (sift :move {#".*vega-tooltip\.css$"     "cljsjs/vega-tooltip/common/vega-tooltip.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-tooltip" :requires ["cljsjs.vega"])
    (pom)
    (jar)))
