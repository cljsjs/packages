(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                  [cljsjs/vega "3.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.12.0")

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
     :checksum "9DA40C6DFB095BECD7DED0C1140306C7")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/build/vega-tooltip.min.js" +lib-version+)
     :checksum "8F16944530FD101C250FD6C83FC88205")
    (download
     :url (format "https://unpkg.com/vega-tooltip@%s/vega-tooltip.css" +lib-version+)
     :checksum "CA9DC27595BBADC7048370EE79FABB8D")
    (sift :move {#".*vega-tooltip\.js$"      "cljsjs/development/vega-tooltip.inc.js"})
    (sift :move {#".*vega-tooltip\.min\.js$" "cljsjs/production/vega-tooltip.min.inc.js"})
    (sift :move {#".*vega-tooltip\.css$"     "cljsjs/common/vega-tooltip.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-tooltip"
               :requires ["cljsjs.vega"])
    (pom)
    (jar)))


;;; No longer works as IDL for some reason no longer includes builds!!
#_(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
      :url (str "https://github.com/vega/vega-tooltip/archive/v" +lib-version+ ".zip")
      :unzip true
      :checksum "36C689DD687FCDDF642FCABD79C44210")
    (sift :move {(re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.js$")) "cljsjs/development/vega-tooltip.inc.js"
                 (re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.css$")) "cljsjs/development/vega-tooltip.css"
                 (re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.min.js$")) "cljsjs/production/vega-tooltip.min.inc.js"
                 (re-pattern (str "^vega-tooltip-" +lib-version+ "/build/vega-tooltip.min.css$")) "cljsjs/production/vega-tooltip.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-tooltip"
               :requires ["cljsjs.vega"])
    (pom)
    (jar)))
