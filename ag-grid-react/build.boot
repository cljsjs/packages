(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "16.0.0-0" :scope "provided"]
                  [cljsjs/react-dom "16.0.0-0" :scope "provided"]
                  [cljsjs/ag-grid "15.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [dosh]]
         '[clojure.java.io :as io])

(def +lib-version+ "17.0.0")
(def +lib-checksum+ "7BEBAFD4BBCE29CE1B9EB02A88C2E62E")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "ag-grid-react-%s" +lib-version+))

(defn- dosh-cmd [& args]
       (apply dosh (if (re-find #"^Windows" (.get (System/getProperties) "os.name"))
                     (into ["cmd.exe" "/c"] args)
                     args)))

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
                   :checksum +lib-checksum+
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
                                   (dosh-cmd "npm" "install")
                                   (dosh-cmd "npm" "install" "ag-grid" "gulp" "webpack@^1.9.11")
                                   (dosh-cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/gulp")))
                                   (dosh-cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/webpack")) "--config" "webpack-cljsjs.config.js"))
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
