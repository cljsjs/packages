(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.10.597"]
                 [cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "5.17.0")
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
     :checksum "EBC6FF295AA41C72E3B8C3A897BBFABD")
    (download
     :url (format "https://unpkg.com/vega@%s/build/vega.min.js" +lib-version+)
     :checksum "23E3A29E67EF95A6D2D694AE17876259")
    (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                 (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega")
    (pom)
    (jar)
    (validate)))
