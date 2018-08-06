(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                  [cljsjs/vega "3.3.1-0"]
                  [cljsjs/vega-lite "2.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.16.1")
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
     :url (format "https://unpkg.com/vega-embed@%s/build/vega-embed.js" +lib-version+)
     :checksum "7302414784D5272634D3B9AF87B51B58")
    (download
     :url (format "https://unpkg.com/vega-embed@%s/build/vega-embed.min.js" +lib-version+)
     :checksum "86D394AE8F44A84932B8A20BD957ACE6")
    (sift :move {#".*vega-embed\.js$"   "cljsjs/development/vega-embed.inc.js"})
    (sift :move {#".*vega-embed\.min\.js$"   "cljsjs/production/vega-embed.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-embed"
               :requires ["cljsjs.vega" "cljsjs.vega-lite"])
    (pom)
    (jar)))
