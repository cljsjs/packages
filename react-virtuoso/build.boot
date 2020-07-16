(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.17.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/react-virtuoso
        :version     +version+
        :description "React Virtuoso is a simple, easy to use React virtualized list component that can render huge data sets. "
        :url         "https://virtuoso.dev/"
        :license     {"MIT" "https://github.com/petyosi/react-virtuoso/blob/v0.17.5/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-react-virtuoso []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-virtuoso-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "run" "build" "--" "--format" "umd" "--name" "ReactVirtuoso")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download :url (format "https://github.com/petyosi/react-virtuoso/archive/v%s.zip" +lib-version+)
              :unzip true)
    (build-react-virtuoso)
    (sift :move {#".*reactvirtuoso.umd.development.js$"
                 "cljsjs/react-virtuoso/development/react-virtuoso.inc.js"
                 #".*reactvirtuoso.umd.production.min.js$"
                 "cljsjs/react-virtuoso/production/react-virtuoso.min.inc.js"})
    (replace-content
      :in "cljsjs/react-virtuoso/development/react-virtuoso.inc.js"
      :match #"\/\/\#.*\n"
      :value "")
    (replace-content
      :in "cljsjs/react-virtuoso/production/react-virtuoso.min.inc.js"
      :match #"\/\/\#.*\n"
      :value "")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :foreign-libs [{:file #"react-virtuoso.inc.js"
                               :file-min #"react-virtuoso.min.inc.js"
                               :provides ["react-virtuoso" "cljsjs.react-virtuoso"]
                               :requires ["cljsjs.react" "cljsjs.react.dom"]
                               :global-exports '{react-virtuoso ReactVirtuoso}}]
               :externs [#"react-virtuoso.ext.js"])
    (pom)
    (jar)
    (validate)))
