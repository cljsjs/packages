(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojurescript "1.10.597"]
                  [cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "6.19.0")
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
     :checksum "9FBE7386F3C7082F563CF19D79FEC76C")
    (download
     :url (format "https://unpkg.com/vega-embed@%s/build/vega-embed.min.js" +lib-version+)
     :checksum "16787774859191C83D203476E2AE4322")
    (sift :move {#".*vega-embed\.js$"      "cljsjs/development/vega-embed.inc.js"})
    (sift :move {#".*vega-embed\.min\.js$" "cljsjs/production/vega-embed.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-embed" :requires ["cljsjs.vega" "cljsjs.vega-lite"])
    (pom)
    (jar)))
