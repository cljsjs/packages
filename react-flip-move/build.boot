(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]]
         '[clojure.string :as str])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/react-flip-move
        :version     +version+
        :description "Effortless animation between DOM changes (eg. list reordering) using the FLIP technique."
        :url         "https://github.com/joshwcomeau/react-flip-move.git"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/react-flip-move@" +lib-version+ "/dist/react-flip-move.js"))
    (download :url (str "https://unpkg.com/react-flip-move@" +lib-version+ "/dist/react-flip-move.min.js"))

    (sift :move {#"react-flip-move\.js" "cljsjs/react-flip-move/development/react-flip-move.inc.js"
                 #"react-flip-move.min\.js" "cljsjs/react-flip-move/production/react-flip-move.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :provides ["react-flip-move" "cljsjs.react-flip-move"]
               :global-exports '{react-flip-move FlipMove}
               :requires ["react"
                          "react-dom"])
    (pom)
    (jar)
    (validate)))
