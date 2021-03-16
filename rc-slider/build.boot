(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "17.0.1-0"]
                  [cljsjs/react-dom "17.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "9.7.1")
(def +version+ (str +lib-version+ "-1"))

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

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*rc-slider.inc.js"     "cljsjs/rc-slider/development/rc-slider.inc.js"
                #".*rc-slider.min.inc.js" "cljsjs/rc-slider/production/rc-slider.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.rc-slider")
   (deps-cljs :foreign-libs [{:file #"rc-slider.inc.js"
                              :file-min #"rc-slider.min.inc.js"
                              :provides ["cljsjs.rc-slider"]
                              :global-exports '{"rc-slider" RcSlider}
                              :requires       ["react" "react-dom"]}]
              :externs [#"rc-slider.ext.js"])
   (pom)
   (jar)
   (validate)))
