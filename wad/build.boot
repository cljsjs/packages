(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.2.3")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/wad
       :version     +version+
       :description "Web Audio DAW. Use the HTML5 Web Audio API for dynamic sound synthesis."
       :url         "http://www.codecur.io/us/songdemo"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/rserota/wad/archive/2.2.3.zip"
              :checksum "8243AC4A291BCDB214094C0BA8BDA1B4"
              :unzip true)
    (sift :move {#"^wad-.*/build/wad.js" "cljsjs/development/wad.inc.js"
                 #"^wad-.*/build/wad.min.js" "cljsjs/production/wad.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.wad")))
