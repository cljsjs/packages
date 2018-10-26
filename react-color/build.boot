(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "15.4.2-2"]
                  [cljsjs/lodash "4.11.2-0"]
                  [cljsjs/tinycolor "1.4.1-0"]
                  [cljsjs/proptypes "0.14.3-0"]
                  [cljsjs/material-colors "1.2.5-0"]
                  [cljsjs/reactcss "1.2.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "2.13.8")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-color-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-color
       :version     +version+
       :description "A React based set of Color Pickers and components"
       :url         "http://casesandberg.github.io/react-color"
       :scm         {:url "https://github.com/casesandberg/react-color"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-color []
  (download  :url      (format "https://github.com/casesandberg/react-color/archive/v%s.zip" +lib-version+)
             :checksum "1d0d832d217a675cb9dcf4618c66c01a"
             :unzip    true))

(def webpack-file-name "webpack.config.js")
(def main-file-name "main.js")

(deftask build []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap
                fileset
                (doseq [f (boot/input-files fileset)]
                       (let [target (io/file tmp (tmpd/path f))]
                            (io/make-parents target)
                            (io/copy (tmpd/file f) target)))
                (io/copy
                  (io/file tmp main-file-name)
                  (io/file tmp +lib-folder+ main-file-name))
                (io/copy
                  (io/file tmp "webpack.config.js")
                  (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
                (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
                         ((sh "npm" "install" "--ignore-scripts"))
                         ((sh "npm" "install" "webpack@3"))
                         ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-react-color)
   (build)
   (sift :move {#".*react-color.inc.js" "cljsjs/react-color/development/react-color.inc.js"})
   (sift :include #{#"^cljsjs"})

   (minify :in  "cljsjs/react-color/development/react-color.inc.js"
           :out "cljsjs/react-color/production/react-color.min.inc.js"
           :lang :ecmascript5)

   (deps-cljs :name "cljsjs.react-color"
              :requires ["cljsjs.react" "cljsjs.lodash" "cljsjs.tinycolor"
                         "cljsjs.proptypes" "cljsjs.material-colors" "cljsjs.reactcss"])
   (pom)
   (jar)))
