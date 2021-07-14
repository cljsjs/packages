(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.10.597"]
                 [cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "5.20.2")
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
     :checksum "379BEC16B79201329017322BAAD9861F")
    (download
     :url (format "https://unpkg.com/vega@%s/build/vega.min.js" +lib-version+)
     :checksum "2D86D970BA0821636FBDDC56EAA71751")
    (sift :move {(re-pattern "^vega.js$") "cljsjs/development/vega.inc.js"
                 (re-pattern "^vega.min.js$") "cljsjs/production/vega.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega")
    (pom)
    (jar)
    (validate)))
