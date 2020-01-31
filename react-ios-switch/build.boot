(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "15.6.2-4"]
                  [cljsjs/react-dom "15.6.2-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.1.19")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/react-ios-switch
        :version     +version+
        :description "React switch component inspired by iOS 7+ UISwitch."
        :url         "https://clari.github.io/react-ios-switch/"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-react-ios-switch []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap
                fileset
                ;; Copy all files in fileset to temp directory
                (doseq [f (->> fileset boot/input-files)
                        :let [target (io/file tmp (tmpd/path f))]]
                       (io/make-parents target)
                       (io/copy (tmpd/file f) target))
                (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-ios-switch-%s" +lib-version+)))]
                         ((sh "npm" "install" "--ignore-scripts"))
                         ((sh "npm" "run" "babel"))
                         ((sh "npm" "run" "umd")))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download :url (str "https://github.com/clari/react-ios-switch/archive/v" +lib-version+ ".zip")
                     :unzip true)
           (build-react-ios-switch)
           (sift :move {#"^react-ios-switch-(.*)/build/bundle.js$" "cljsjs/react-ios-switch/development/react-ios-switch.inc.js"})
           (minify :in "cljsjs/react-ios-switch/development/react-ios-switch.inc.js"
                   :out "cljsjs/react-ios-switch/production/react-ios-switch.min.inc.js")
           (sift :include #{#"^cljsjs"})

           (deps-cljs :name "cljsjs.react-ios-switch"
                      :requires ["cljsjs.react"
                                 "cljsjs.react.dom"])
           (pom)

           (jar)))