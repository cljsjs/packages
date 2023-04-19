(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "15.3.0-0"]
                  [cljsjs/classnames "2.2.3-0"]])

(def +lib-version+ "1.0.0-beta2")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-date-range-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-date-range
       :version     +version+
       :description "A React component for choosing dates and date ranges"
       :url         "https://github.com/Adphorus/react-date-range"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/Adphorus/react-date-range/archive/v%s.zip" +lib-version+))

(deftask download-react-date-range []
         (download :url url
                   :unzip true))

(def main-file-name "main.js")
(def webpack-file-name "webpack.config.js")

; (defn get-file [fileset file-name]
;       (io/file
;         (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
;         file-name))

(deftask build []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
       (io/file tmp "build/webpack.config.js")
       (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install" "--ignore-scripts"))
        ((sh "npm" "install" "webpack"))
        ((sh "npm" "run" "build"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
         (comp
           (download-react-date-range)
           (build)
           (sift :move {#".*react-date-range.js$" "cljsjs/react-date-range/development/react-date-range.inc.js"
                        #".*styles.css$" "cljsjs/react-date-range/development/styles.inc.css"
                        #".*default.css$" "cljsjs/react-date-range/development/theme/default.inc.css"})
           (minify :in  "cljsjs/react-date-range/development/react-date-range.inc.js"
                   :out "cljsjs/react-date-range/production/react-date-range.min.inc.js")
           (minify :in  "cljsjs/react-date-range/development/styles.inc.css"
                   :out "cljsjs/react-date-range/production/styles.min.inc.css")
           (minify :in  "cljsjs/react-date-range/development/theme/default.inc.css"
                   :out "cljsjs/react-date-range/production/theme/default.min.inc.css")
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.react-date-range" :requires ["cljsjs.react"])
           (pom)
           (jar)
           (validate-checksums)))
