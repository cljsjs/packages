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
    (download :url "https://github.com/victorquinn/chancejs/archive/0.7.3.zip"
              :checksum "fc430e44258756648d27355ce36180a8"
              :unzip true)
    (sift :move {#"^chancejs-\d+\.\d+\.\d+/chance\.js" "cljsjs/common/chance.inc.js"})
    (sift :include #{#"^cljsjs/" #"^deps.cljs$"})))
