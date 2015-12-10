(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.3.2")
(bootlaces! +version+)

(task-options!
 pom {:project     'cljsjs/spin
      :version     +version+
      :description "A spinning activity indicator"
      :url         "http://spin.js.org"
      :scm         {:url "https://github.com/fgnass/spin.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/fgnass/spin.js/archive/2.3.2.zip"
              :checksum "71a0e4985a2711589f2e5eecfec3e416"
              :unzip true)
    (sift :move {#"^spin\.js-2\.3\.2/spin\.js" "cljsjs/spin/development/spin.inc.js"
                 #"^spin\.js-2\.3\.2/spin\.min\.js" "cljsjs/spin/production/spin.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.spin")))
