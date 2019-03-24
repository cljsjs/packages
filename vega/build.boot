(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/vega
      :version     +version+
      :description "Vega is a declarative format for creating, saving, and sharing visualization designs"
      :url         "https://vega.github.io/"
      :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download
     :url (format "https://unpkg.com/vega@%s/build/vega.js" +lib-version+)
     :checksum "3476c1a0e3760c07e24e82c8023124e3")
    (download
     :url (format "https://unpkg.com/vega@%s/build/vega.min.js" +lib-version+)
     :checksum "41748bd2aa71e63e29307965fbc21f26")
   (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.vega")
   (pom)
   (jar)
   (validate)))
