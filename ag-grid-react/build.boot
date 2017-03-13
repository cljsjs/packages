(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react "15.2.1-0" :scope "provided"]
                  [cljsjs/react-dom "15.2.1-0" :scope "provided"]
                  [cljsjs/ag-grid "8.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [sh]]
         '[clojure.java.io :as io])

(def +lib-version+ "8.0.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "ag-grid-react-%s" +lib-version+))

(defn- cmd [x]
  (cond-> x
          (re-find #"^Windows" (.get (System/getProperties) "os.name")) (str ".cmd")))

(defn- path [x]
  (.toString (java.nio.file.Paths/get x (into-array String nil))))

(task-options!
  pom {:project     'cljsjs/ag-grid-react
       :version     +version+
       :description "The JavaScript Datagrid for Enterprise"
       :url         "http://ag-grid.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
         (download :url (format "https://github.com/ceolter/ag-grid-react/archive/%s.zip" +lib-version+)
                   :checksum "C49E2D16E2998039DC5ACA718966C3F6"
                   :unzip true))

(deftask build []
         (let [tmp (boot/tmp-dir!)]
           (with-pre-wrap fileset
                          (doseq [f (boot/input-files fileset)
                                  :let [target (io/file tmp (tmpdir/path f))]]
                            (io/make-parents target)
                            (io/copy (tmpdir/file f) target))
                          (io/copy
                            (io/file tmp "webpack.config.js")
                            (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
                          (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
                            ((sh (cmd "npm") "install"))
                            ((sh (cmd "npm") "install" "ag-grid" "gulp" "webpack@^1.9.11"))
                            ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/gulp")))))
                            ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/webpack"))) "--config" "webpack-cljsjs.config.js")))
                          (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download-lib)
           (build)
           (sift :move {#".*ag-grid-react.inc.js" "cljsjs/ag-grid-react/development/ag-grid-react.inc.js"})
           (sift :include #{#"^cljsjs"})
           (minify :in "cljsjs/ag-grid-react/development/ag-grid-react.inc.js"
                   :out "cljsjs/ag-grid-react/production/ag-grid-react.min.inc.js"
                   :lang :ecmascript5)
           (deps-cljs :name "cljsjs.ag-grid-react"
                      :requires ["cljsjs.react"
                                 "cljsjs.react.dom"
                                 "cljsjs.ag-grid"])
           (pom)
           (jar)))
