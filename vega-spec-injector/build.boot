(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.10.597"]
                 [cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/vega-spec-injector
      :version     +version+
      :description "Vega spec injector is a tool for manipulating Vega specs"
      :url         "https://github.com/nyurik/vega-spec-injector"
      :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download
     :url (format "https://unpkg.com/vega-spec-injector@%s/dist/vegaSpecInjector.js" +lib-version+)
     :checksum "5134be372f538048e77c242cfce58f12")
    (download
     :url (format "https://unpkg.com/vega-spec-injector@%s/dist/vegaSpecInjector.min.js" +lib-version+)
     :checksum "f89c9b938c75a8cb2a81160ba74ed50f")
    (sift :move {(re-pattern "^vegaSpecInjector.js$") "cljsjs/development/vega-spec-injector.inc.js"
                 (re-pattern "^vegaSpecInjector.min.js$") "cljsjs/production/vega-spec-injector.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega-spec-injector")
    (pom)
    (jar)
    (validate)))
