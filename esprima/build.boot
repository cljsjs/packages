(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.7.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/esprima
       :version     +version+
       :description "ECMAScript parsing infrastructure for multipurpose analysis"
       :url         "https://github.com/jquery/esprima"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/jquery/esprima/archive/"
                        +lib-version+ ".zip")
              :checksum "2b04ea69dc7ddd22d605ce5bb956a1fa"
              :unzip true)
    (sift :move {#"^esprima-(.*)/esprima.js$"
                 "cljsjs/esprima/development/esprima.inc.js"})
    (minify :in "cljsjs/esprima/development/esprima.inc.js"
            :out "cljsjs/esprima/production/esprima.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.esprima")
    (pom)
    (jar)))
