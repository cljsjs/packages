(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/typedjs
       :version     +version+
       :description "jQuery plugin that types."
       :url         "http://www.mattboldt.com/demos/typed-js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (format "https://github.com/mattboldt/typed.js/archive/v%s.zip" +lib-version+)
             :checksum "791D8C8904ADDBC91C828502DA663A82"
             :unzip    true)
   (sift :move {(re-pattern (str "^typed.js-" +lib-version+ "/js/typed.js$"))  "cljsjs/typedjs/development/typed.inc.js"
                (re-pattern (str "^typed.js-" +lib-version+ "/dist/typed.min.js$"))  "cljsjs/typedjs/production/typed.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.typedjs"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
