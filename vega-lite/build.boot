(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/vega "4.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0-rc10")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/vega-lite
       :version     +version+
       :description "A high-level grammar for visual analysis, built on top of Vega."
       :url         "https://vega.github.io/vega-lite"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
      :url (str "https://github.com/vega/vega-lite/archive/v" +lib-version+ ".zip")
      :unzip true
      :checksum "6EB2917D7331C7CCA770C4E2C3A43AD7")
    (sift :move {(re-pattern (str "^vega-lite-" +lib-version+ "/build/vega-lite.js$")) "cljsjs/development/vega-lite.inc.js"
                 (re-pattern (str "^vega-lite-" +lib-version+ "/build/vega-lite.min.js$")) "cljsjs/production/vega-lite.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-lite"
               :requires ["cljsjs.vega"])
    (pom)
    (jar)))
