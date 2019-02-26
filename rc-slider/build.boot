(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "16.2.0-3"]
                  [cljsjs/react-dom "16.2.0-3"]
                  [cljsjs/classnames "2.2.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "8.6.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/rc-slider
       :version     +version+
       :description "Slider ui component for React"
       :url         "https://github.com/react-component/slider"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn- cmd [x]
  (cond-> x
          (re-find #"^Windows" (.get (System/getProperties) "os.name")) (str ".cmd")))

(defn- path [x]
  (.toString (java.nio.file.Paths/get x (into-array String nil))))

(deftask build []
  (let [tmp (boot/tmp-dir!)
        +lib-folder+ (str "slider-" +lib-version+)]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
        (io/file tmp "build/webpack.config.js")
        (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh (cmd "npm") "install" "--production"))
        ((sh (cmd "npm") "install" "react" "react-dom" "webpack@3" "babel-loader" "babel-core" "babel-preset-react" "babel-preset-env" "babel-preset-stage-0" "babel-plugin-add-module-exports" "less"))
        ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/webpack"))) "--config" "webpack-cljsjs.config.js"))
        ((sh (cmd (path (str (io/file tmp +lib-folder+) "/node_modules/.bin/lessc"))) "assets/index.less" "rc-slider.css")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download :url (str "https://github.com/react-component/slider/archive/" +lib-version+ ".zip")
              :unzip true)
    (build)
    (sift :move {#".*rc-slider.js" "cljsjs/rc-slider/development/rc-slider.inc.js"
                 #".*rc-slider.min.js" "cljsjs/rc-slider/production/rc-slider.min.inc.js"
                 #".*rc-slider.css" "cljsjs/rc-slider/common/rc-slider.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.rc-slider"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"
                          "cljsjs.classnames"])
    (pom)
    (jar)
    (validate)))
