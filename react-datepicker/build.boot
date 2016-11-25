(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]
                  [cljsjs/moment "2.10.6-4"]
                  [cljsjs/react-onclickoutside "4.9.0-2"]
                  [cljsjs/tether "1.1.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.29.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-datepicker
       :version     +version+
       :description "A simple and reusable datepicker component for React"
       :url         "http://hacker0x01.github.io/react-datepicker"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-datepicker []
  (download :url (str "https://github.com/Hacker0x01/react-datepicker/archive/v" +lib-version+ ".zip")
            :checksum "b2e536c347d4589e32615e9f2eee6bbd"
            :unzip true))

(deftask build-datepicker []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-datepicker-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "gem" "install" "scss_lint"))
        ((sh "npm" "run" "build")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
  (comp
    (download-datepicker)
    (build-datepicker)
    (sift :move {#"^react-datepicker.*[/ \\]dist[/ \\]react-datepicker.js$" "cljsjs/react-datepicker/development/react-datepicker.inc.js"
	         #"^react-datepicker.*[/ \\]dist[/ \\]react-datepicker.min\.js$" "cljsjs/react-datepicker/production/react-datepicker.min.inc.js"
	         #"^react-datepicker.*[/ \\]dist[/ \\]react-datepicker.css$" "cljsjs/react-datepicker/common/react-datepicker.inc.css"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-datepicker"
               :requires ["cljsjs.react"
                          "cljsjs.moment"
                          "cljsjs.react-onclickoutside"
                          "cljsjs.tether"])
    (pom)
    (jar)))
