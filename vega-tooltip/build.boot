(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/vega "4.3.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.13.0")

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
     :checksum "b0799bddd441d21ca22a8d1f300d1437")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/build/vega-tooltip.min.js" +lib-version+)
     :checksum "cb4d2d7f3d9a458a60a1b8068544840c")
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
