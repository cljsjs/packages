(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "16.2.0-3"]
                  [cljsjs/react-dom "16.2.0-3"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.12.18")
(def +version+ (str +lib-version+ "-0"))

; the main repo is unresponsive; this commit on this repo
; represents a branch off the above +lib-version+ with support
; for building as UMD.
(def +commit+ "01b6f62d5549fd7477d28970597dc0f08ae786b2")
(def +repo-owner+ "dhleong")

(task-options!
 pom  {:project     'cljsjs/react-swipeable-views
       :version     +version+
       :description "A React component for swipeable views"
       :url         "https://react-swipeable-views.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-react-swipeable-views []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (str "react-swipeable-views-" +commit+)))]
        ((sh "npm" "install" "--ignore-scripts"))
        ((sh "npm" "run" "build:umd")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    ;; (download :url (str "https://github.com/oliviertassinari/react-swipeable-views/archive/v" +lib-version+ ".zip")
    (download :url (str "https://github.com/" +repo-owner+
                        "/react-swipeable-views/archive/" +commit+
                        ".zip")
              :unzip true)
    (build-react-swipeable-views)
    (sift :move {#"^react-swipeable-views-(.*)/lib/umd/react-swipeable-views.js$" "cljsjs/react-swipeable-views/development/react-swipeable-views.inc.js"})
    (minify :in "cljsjs/react-swipeable-views/development/react-swipeable-views.inc.js"
            :out "cljsjs/react-swipeable-views/production/react-swipeable-views.min.inc.js")
    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-swipeable-views"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)

    (jar)

    (validate-checksums)))
