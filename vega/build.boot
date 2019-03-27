(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.3.2")
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
     :checksum "a830568f8b8ae48c0a7a884e14d751d8")
    (download
     :url (format "https://unpkg.com/vega@%s/build/vega.min.js" +lib-version+)
     :checksum "c6f9ecfd22214d3413e3454d1075987d")
   (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.vega")
   (pom)
   (jar)
   (validate)))
