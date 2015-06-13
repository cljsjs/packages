(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.3.2-0")
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/klayjs
       :version     +version+
       :description "A layer-based layout algorithm, particularly suited for node-link diagrams with an inherent direction and ports."
       :url         "https://github.com/OpenKieler/klayjs"
       :scm         {:url "https://github.com/OpenKieler/klayjs"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
    (download :url "https://github.com/OpenKieler/klayjs/archive/0.3.2.zip"
              :unzip true)
    (sift :move {#"^klayjs-.*/klay.js" "cljsjs/development/klay.inc.js"})
    (minify :in "cljsjs/development/klay.inc.js"
            :out "cljsjs/production/klay.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.klayjs")))
