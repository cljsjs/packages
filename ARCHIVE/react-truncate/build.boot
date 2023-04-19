(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(def +lib-version+ "2.0.3")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-truncate-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-truncate
       :version     +version+
       :description "React component for truncating multi-line spans and adding an ellipsis"
       :url         "https://github.com/One-com/react-truncate"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/One-com/react-truncate/archive/v%s.zip" +lib-version+))

(deftask download-react-truncate []
         (download :url url
                   :checksum "753af3aa3f6fab1d56bd24ffecaf7510"
                   :unzip true))

(def webpack-file-name "webpack.config.js")

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
                         ((sh "npm" "install" "--ignore-scripts"))
                         ((sh "npm" "run" "compile"))
                         ((sh "npm" "install" "webpack"))
                         ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
   (comp
     (download-react-truncate)
     (build)
     (sift :move {#".*react-truncate.inc.js" "cljsjs/react-truncate/development/react-truncate.inc.js"})
     (sift :include #{#"^cljsjs"})

     (minify :in  "cljsjs/react-truncate/development/react-truncate.inc.js"
             :out "cljsjs/react-truncate/production/react-truncate.min.inc.js")

     (deps-cljs :name "cljsjs.react-truncate" :requires ["cljsjs.react"])
     (pom)
     (jar)))
