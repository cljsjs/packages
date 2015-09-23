(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.5.2")
(bootlaces! +version+)

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/airbrake
        :version     +version+
        :description "Airbrake JavaScript Notifier https://airbrake.io"
        :url         "https://github.com/airbrake/airbrake-js"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url "https://github.com/airbrake/airbrake-js/archive/v0.5.2.zip"
              :checksum "acc9fcccd6a85feb7747dd7d82bd131a"
              :unzip true)

    (sift :move {#"^airbrake-.*/dist/client\.js"          "cljsjs/airbrake/development/airbrake.inc.js"
                 #"^airbrake-.*/dist/client\.js"          "cljsjs/airbrake/production/airbrake.inc.js"
})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.airbrake")))
