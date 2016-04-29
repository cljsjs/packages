(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/d3 "3.5.7-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.0")

(def +version+ (str +lib-version+ "-0"))

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
      :url (str "https://github.com/vega/vega/archive/v" +lib-version+ ".zip")
      :unzip true
      :checksum "5AFB54BE6EBACB09A8EC84432F28E791")
    (sift :move {(re-pattern (str "^vega-" +lib-version+ "/vega.js$")) "cljsjs/development/vega.inc.js"
                 (re-pattern (str "^vega-" +lib-version+ "/vega.min.js$")) "cljsjs/production/vega.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega"
               :requires ["cljsjs.d3"])
    (pom)
    (jar)))
