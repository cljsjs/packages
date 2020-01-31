(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojurescript "1.10.597"]
                  [cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/vega "5.9.0-0"]
                  [cljsjs/vega-lite "4.0.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "6.0.0")
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
     :checksum "70e2ff3cdb6f03d26a3a3e734b521f05")
    (download
     :url (format "https://unpkg.com/vega-embed@%s/build/vega-embed.min.js" +lib-version+)
     :checksum "3d09a1061a681e0c181098c936b83eeb")
    (sift :move {#".*vega-embed\.js$"      "cljsjs/development/vega-embed.inc.js"})
    (sift :move {#".*vega-embed\.min\.js$" "cljsjs/production/vega-embed.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-embed" :requires ["cljsjs.vega" "cljsjs.vega-lite"])
    (pom)
    (jar)))
