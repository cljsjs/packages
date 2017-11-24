(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]]
         '[clojure.string :as str])

(def +lib-version+ "2.9.17")
(def +version+ (str +lib-version+ "-0"))
(def +expected-checksum+ "87472cee553d0dbe9880005107dd6cc1")
(def +expected-checksum-min+ "deca2909caf12ddac7c0ae1c6d545b50")

(task-options!
  pom  {:project     'cljsjs/react-flip-move
        :version     +version+
        :description "Effortless animation between DOM changes (eg. list reordering) using the FLIP technique."
        :url         "https://github.com/joshwcomeau/react-flip-move.git"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-flip-move  []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (let [build-dir (str (io/file
                            tmp
                            (format "react-flip-move-%s" +lib-version+)))]
        (binding [boot.util/*sh-dir* build-dir]
          ((sh "npm" "install"))))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/react-flip-move@" +lib-version+ "/dist/react-flip-move.js")
              :checksum +expected-checksum+)
    (download :url (str "https://unpkg.com/react-flip-move@" +lib-version+ "/dist/react-flip-move.min.js")
              :checksum +expected-checksum-min+)

    (sift :move {#"react-flip-move\.js" "cljsjs/react-flip-move/development/react-flip-move.inc.js"
                 #"react-flip-move.min\.js" "cljsjs/react-flip-move/production/react-flip-move.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-flip-move"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)
    (jar)))

