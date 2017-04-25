(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0-beta.30")
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
      :checksum "288805712a24d191429f567325134766")
    (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                 (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega")
    (pom)
    (jar)))

