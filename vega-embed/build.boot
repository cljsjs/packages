(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/vega "3.0.0-beta.27-0"]
                  [cljsjs/vega-lite "2.0.0-alpha.7-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0-beta.6")

(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/vega-embed
       :version     +version+
       :description "Publish Vega visualizations as embedded web components with interactive parameters."
       :url         "https://vega.github.io/vega-embed"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
      :url (str "https://github.com/vega/vega-embed/archive/v" +lib-version+ ".zip")
      :unzip true
      :checksum "7E5EC9D8D94EBF8972561BFAF30151A0")
    (sift :move {(re-pattern (str "^vega-embed-" +lib-version+ "/vega-embed.js$")) "cljsjs/development/vega-embed.inc.js"
                 (re-pattern (str "^vega-embed-" +lib-version+ "/vega-embed.min.js$")) "cljsjs/production/vega-embed.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-embed"
               :requires ["cljsjs.vega" "cljsjs.vega-lite"])
    (pom)
    (jar)))
