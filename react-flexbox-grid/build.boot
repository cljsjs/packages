(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react "15.4.2-2"]])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-flexbox-grid-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-flexbox-grid
       :version     +version+
       :description "A set of React components implementing flexboxgrid with the power of CSS Modules."
       :url         "https://github.com/roylee0704/react-flexbox-grid"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/roylee0704/react-flexbox-grid/archive/v%s.zip" +lib-version+))

(deftask download-react-flexbox-grid []
         (download :url url
                   :checksum "0d5cca6ee8c7c79dbfdd95e063b8ce01"
                   :unzip true))

(def webpack-file-name "webpack.config.js")

(defn get-file [fileset file-name]
      (io/file
        (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
        file-name))

(deftask build []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
       (io/file tmp "webpack.config.js")
       (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "webpack"))
        ((sh "npm" "run" "build"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
   (comp
     (download-react-flexbox-grid)
     (build)
     (sift :move {#".*react-flexbox-grid.inc.js" "cljsjs/react-flexbox-grid/development/react-flexbox-grid.inc.js"
                  #".*react-flexbox-grid.inc.css" "cljsjs/react-flexbox-grid/development/react-flexbox-grid.inc.css"})
     (sift :include #{#"^cljsjs"})

     (minify :in  "cljsjs/react-flexbox-grid/development/react-flexbox-grid.inc.js"
             :out "cljsjs/react-flexbox-grid/production/react-flexbox-grid.min.inc.js")

     (minify :in  "cljsjs/react-flexbox-grid/development/react-flexbox-grid.inc.css"
             :out "cljsjs/react-flexbox-grid/production/react-flexbox-grid.min.inc.css")

     (deps-cljs :name "cljsjs.react-flexbox-grid" :requires ["cljsjs.react"])
     (pom)
     (jar)))
