(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [javax.xml.bind/jaxb-api "2.3.0"]
                  [cljsjs/vega "5.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.18.1")

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
     :checksum "98a04b89eb46785e97f3ffe7d17d7138")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/build/vega-tooltip.min.js" +lib-version+)
     :checksum "cfd3d20bcb0fd915158904fd91566d0e")
    (sift :move {#".*vega-tooltip\.js$"      "cljsjs/vega-tooltip/development/vega-tooltip.inc.js"})
    (sift :move {#".*vega-tooltip\.min\.js$" "cljsjs/vega-tooltip/production/vega-tooltip.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-tooltip" :requires ["cljsjs.vega"])
    (pom)
    (jar)))
