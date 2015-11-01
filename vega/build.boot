(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/d3 "3.5.5-3"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def vega-version "2.2.5")

(def +version+ (str vega-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/vega
       :version     +version+
       :description "Vega is a declarative format for creating, saving, and sharing visualization designs"
       :url         "https://vega.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
      :url (str "https://github.com/vega/vega/archive/v" vega-version ".zip")
      :unzip true
      :checksum "72A040B2FE6F62328DB02C7C0E0DA68D")
    (sift :move {(re-pattern (str "^vega-" vega-version "/vega.js$")) "cljsjs/development/vega.inc.js"
                 (re-pattern (str "^vega-" vega-version "/vega.min.js$")) "cljsjs/production/vega.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega"
               :requires ["cljsjs.d3"])))
