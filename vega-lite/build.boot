(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojurescript "1.10.597"]
                  [cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  ;;;[cljsjs/vega "5.17.0-0"]
                  ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "4.17.0")
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
     :url (format "https://unpkg.com/vega-lite@%s/build/vega-lite.js" +lib-version+)
     :checksum "CD574F608F30EBFB3FE801F5C5D3A279")
    (download
     :url (format "https://unpkg.com/vega-lite@%s/build/vega-lite.min.js" +lib-version+)
     :checksum "C0C5E4CE93A681084745698A14FA3789")
    (sift :move {(re-pattern "^vega-lite.js$") "cljsjs/development/vega-lite.inc.js"
                 (re-pattern "^vega-lite.min.js$") "cljsjs/production/vega-lite.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-lite"
               :requires ["cljsjs.vega"])
    (pom)
    (jar)))
