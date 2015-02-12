(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.3" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.7.3-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/chance
       :version     +version+
       :description "Chance.js packaged up with Google Closure externs"
       :url         "http://chancejs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "http://chancejs.com/chance-0.7.3.js"
              :checksum "1ba2c414dabb25fdd5a078622748935d")
    (download :url "http://chancejs.com/chance-0.7.3.min.js"
              :checksum "6626802c618649c394f817e5142bb4b1")
    (sift :move {#"chance-([\d\.]*).js" "cljsjs/development/chance.inc.js"
                 #"chance-([\d\.]*).min.js" "cljsjs/production/chance.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chance")))
