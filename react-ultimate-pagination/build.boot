(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(def +lib-version+ "0.8.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-ultimate-pagination-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-ultimate-pagination
       :version     +version+
       :description "React.js pagination component based on ultimate-pagination"
       :url         "https://github.com/ultimate-pagination/react-ultimate-pagination"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/ultimate-pagination/react-ultimate-pagination/archive/%s.zip" +lib-version+))

(deftask download-react-ultimate-pagination []
         (download :url url
                   :checksum "5bbc694d5c208f9f352476ef117aa3f7"
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
     (download-react-ultimate-pagination)
     (build)
     (sift :move {#".*react-ultimate-pagination.inc.js" "cljsjs/react-ultimate-pagination/development/react-ultimate-pagination.inc.js"})
     (sift :include #{#"^cljsjs"})

     (minify :in  "cljsjs/react-ultimate-pagination/development/react-ultimate-pagination.inc.js"
             :out "cljsjs/react-ultimate-pagination/production/react-ultimate-pagination.min.inc.js")

     (deps-cljs :name "cljsjs.react-ultimate-pagination" :requires ["cljsjs.react"])
     (pom)
     (jar)))
