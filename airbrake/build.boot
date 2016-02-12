(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "0.5.3")
(def +version+ (str +lib-version+ "-0"))

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
    (download :url (format "https://github.com/airbrake/airbrake-js/archive/v%s.zip" +lib-version+)
              :checksum "0ea51136131c1feca422822883ecf4c8"
              :unzip true)

    (sift :move {#"^airbrake-.*/dist/client\.js"          "cljsjs/airbrake/development/airbrake.inc.js"})

    (minify :in "cljsjs/airbrake/development/airbrake.inc.js"
            :out "cljsjs/airbrake/production/airbrake.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.airbrake")))
