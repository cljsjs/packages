(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]
                  [cljsjs/vega "3.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.4")

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
      :url (str "https://github.com/vega/vega-tooltip/archive/v" +lib-version+ ".zip")
      :unzip true
      :checksum "1753378250d44eb030959a8792549f16")
    (sift :move {(re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.js$")) "cljsjs/development/vega-tooltip.inc.js"
                 (re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.css$")) "cljsjs/development/vega-tooltip.css"
                 (re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.min.js$")) "cljsjs/production/vega-tooltip.min.inc.js"
                 (re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.min.css$")) "cljsjs/production/vega-tooltip.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-tooltip"
               :requires ["cljsjs.vega"])
    (pom)
    (jar)))
