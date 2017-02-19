(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/ag-grid "8.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [sh]]
         '[clojure.java.io :as io])

(def +lib-version+ "8.0.1")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "ag-grid-enterprise-%s" +lib-version+))

(defn- cmd [x]
       (cond-> x
               (re-find #"^Windows" (.get (System/getProperties) "os.name")) (str ".cmd")))

(defn- path [x]
       (.toString (java.nio.file.Paths/get x (into-array String nil))))

(task-options!
  pom {:project     'cljsjs/ag-grid-enterprise
       :version     +version+
       :description "The JavaScript Datagrid for Enterprise"
       :url         "http://ag-grid-enterprise.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
         (download :url (format "https://github.com/ceolter/ag-grid-enterprise/archive/%s.zip" +lib-version+)
                   :checksum "214DE44FBA872B13788E36BC10E4FFF1"
                   :unzip true))

(deftask build []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap fileset
                             (doseq [f (boot/input-files fileset)
                                     :let [target (io/file tmp (tmpdir/path f))]]
                                    (io/make-parents target)
                                    (io/copy (tmpdir/file f) target))
                             (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
                                      ((sh (cmd "npm") "install"))
                                      ((sh (cmd "npm") "install" "gulp" "ag-grid" "bower"))
                                      ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/bower"))) "install"))
                                      ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/gulp"))) "webpack-dev")))
                             (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download-lib)
           (build)
           (sift :move {#".*ag-grid-enterprise.js" "cljsjs/ag-grid-enterprise/development/ag-grid-enterprise.inc.js"})
           (sift :include #{#"^cljsjs"})
           (minify :in "cljsjs/ag-grid-enterprise/development/ag-grid-enterprise.inc.js"
                   :out "cljsjs/ag-grid-enterprise/production/ag-grid-enterprise.min.inc.js"
                   :lang :ecmascript5)
           (deps-cljs :name "cljsjs.ag-grid-enterprise"
                      :requires ["cljsjs.ag-grid"])
           (pom)
           (jar)))
