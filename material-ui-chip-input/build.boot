(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/material-ui "0.19.0-0"]
                  [cljsjs/react "15.6.1-1"]])

(def +lib-version+ "0.17.2")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "material-ui-chip-input-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/material-ui-chip-input
       :version     +version+
       :description "A chip input field using Material-UI."
       :url         "https://github.com/TeamWertarbyte/material-ui-chip-input"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/TeamWertarbyte/material-ui-chip-input/archive/v%s.zip" +lib-version+))

(deftask download-material-ui-chip-input []
         (download :url url
                   :checksum "06EFFCB23E852D834B9858E0F89412FF"
                   :unzip true))

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
                         ((sh "npm" "install" "webpack"))
                         ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
   (comp
     (download-material-ui-chip-input)
     (build)
     (sift :move {#".*material-ui-chip-input.inc.js" "cljsjs/material-ui-chip-input/development/material-ui-chip-input.inc.js"})
     (sift :include #{#"^cljsjs"})

     (minify :in  "cljsjs/material-ui-chip-input/development/material-ui-chip-input.inc.js"
             :out "cljsjs/material-ui-chip-input/production/material-ui-chip-input.min.inc.js")

     (deps-cljs :name "material-ui-chip-input" :requires ["react" "cljsjs.material-ui"])
     (pom)
     (jar)))
