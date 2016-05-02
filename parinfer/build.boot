(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.8.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/parinfer
        :version     +version+
        :description "Simpler Lisp Editing"
        :url         "https://github.com/shaunlebron/parinfer"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (format
                     "https://github.com/shaunlebron/parinfer/releases/download/%s/parinfer.js"
                     +lib-version+)
              :checksum "437bc91857a4b237b2e4ad4977d0f962")

    (sift :move {#"^parinfer\.js"
                 "cljsjs/parinfer/development/parinfer.inc.js"})

    (minify :in "cljsjs/parinfer/development/parinfer.inc.js"
            :out "cljsjs/parinfer/production/parinfer.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.parinfer")
    (pom)
    (jar)))
