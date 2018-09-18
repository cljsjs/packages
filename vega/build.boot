(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.1")
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
    :url (str "https://github.com/vega/vega/releases/download/v" +lib-version+ "/vega.zip")
    :unzip true
    :checksum "0A2DC4F5C1DF6E8F50C39DFE8A5652E4")
   (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.vega")
   (pom)
   (jar)))
