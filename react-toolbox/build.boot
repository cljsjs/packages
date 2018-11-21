(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react-with-addons "15.2.1-0" :scope "provided"]
                  [cljsjs/react-dom "15.2.1-0" :scope "provided"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [sh]]
         '[clojure.java.io :as io])

(def +lib-version+ "2.0.0-beta.7")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-toolbox-%s" +lib-version+))

(defn- cmd [x]
  (cond-> x
          (re-find #"^Windows" (.get (System/getProperties) "os.name")) (str ".cmd")))

(defn- path [x]
  (.toString (java.nio.file.Paths/get x (into-array String nil))))

(task-options!
  pom {:project     'cljsjs/react-toolbox
       :version     +version+
       :description "Bootstrap your application with beautiful Material Design Component"
       :url         "http://react-toolbox.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-lib []
         (download :url (format "https://github.com/react-toolbox/react-toolbox/archive/%s.zip" +lib-version+)
                   :checksum "279AFADA1FCAB344DDC67BD7D0C20F49"
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
                            ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/webpack"))) "--config" "webpack-cljsjs.config.js")))
                          (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download-lib)
           (build)
           (sift :move {#".*react-toolbox.inc.js"  "cljsjs/react-toolbox/development/react-toolbox.inc.js"
                        #".*react-toolbox.inc.css" "cljsjs/react-toolbox/development/react-toolbox.inc.css"})
           (sift :include #{#"^cljsjs"})

           (minify :in "cljsjs/react-toolbox/development/react-toolbox.inc.js"
                   :out "cljsjs/react-toolbox/production/react-toolbox.min.inc.js"
                   :lang :ecmascript5)

           (minify :in "cljsjs/react-toolbox/development/react-toolbox.inc.css"
                   :out "cljsjs/react-toolbox/production/react-toolbox.min.inc.css")

           (deps-cljs :name "cljsjs.react-toolbox"
                      :requires ["cljsjs.react"
                                 "cljsjs.react.dom"])

           (pom)
           (jar)))
