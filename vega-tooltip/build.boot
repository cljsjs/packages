(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/vega "5.1.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.16.0")

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
     :checksum "7b84b36c32d6c89689181d58b59e5a9b")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/build/vega-tooltip.min.js" +lib-version+)
     :checksum "6130c3ebe65b2def55ea1b9213d945a4")
    (sift :move {#".*vega-tooltip\.js$"      "cljsjs/vega-tooltip/development/vega-tooltip.inc.js"})
    (sift :move {#".*vega-tooltip\.min\.js$" "cljsjs/vega-tooltip/production/vega-tooltip.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-tooltip" :requires ["cljsjs.vega"])
    (pom)
    (jar)))
