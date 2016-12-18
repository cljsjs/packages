(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]]
         '[clojure.string :as str])

(def +lib-version+ "2.7.2")
(def +version+ (str +lib-version+ "-0"))
(def +expected-checksum+ "06E2C9023B3CB08A4FFABBE31907179B")

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
    (download :url (str "https://github.com/joshwcomeau/"
                        "react-flip-move/archive/v" +lib-version+ ".zip")
              :checksum +expected-checksum+
              :unzip true) 
    (build-flip-move)

    (sift :move {#"^react-flip-move.*[/ \\]dist[/ \\]react-flip-move.js$" "cljsjs/react-flip-move/development/react-flip-move.inc.js"
                 #"^react-flip-move.*[/ \\]dist[/ \\]react-flip-move.min\.js$" "cljsjs/react-flip-move/production/react-flip-move.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-flip-move"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)
    (jar)))

