(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [javax.xml.bind/jaxb-api "2.3.0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.4.0")
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
     :checksum "4e9c5ef9f8e65f9b58875dd6a2ecabee")
    (download
     :url (format "https://unpkg.com/vega@%s/build/vega.min.js" +lib-version+)
     :checksum "a9539bc9715fb136864e1a30be6d104f")
   (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.vega")
   (pom)
   (jar)
   (validate)))
