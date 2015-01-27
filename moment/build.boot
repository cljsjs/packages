(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.2" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.9.0-0")
(bootlaces! +version+)

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/moment
        :version     +version+
        :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
        :url         "http://momentjs.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "https://github.com/moment/moment/archive/2.9.0.zip"
              :checksum "ee7c9584c71459c2c701645a7164a890"
              :unzip true)
    (sift :move {#"^moment-.*/moment.js"         "cljsjs/development/moment.inc.js"
                 #"^moment-.*/min/moment.min.js" "cljsjs/production/moment.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.moment")))
