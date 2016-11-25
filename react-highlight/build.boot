(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.3.0-0"]
                  [cljsjs/highlight "9.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "1.0.5")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-highlight.js-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-highlight
       :version     +version+
       :description "A simple React wrapper around the Highlight.js library"
       :url         "https://github.com/bvaughn/react-highlight.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

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

(deftask download-react-highlight []
  (download :url (str "https://github.com/bvaughn/react-highlight.js/archive/" +lib-version+ ".zip")
            :checksum "8a6903d6db1d51416fd7e19a4dd64ba7"
            :unzip true))

(deftask package []
  (comp
    (download-react-highlight)
    (build)
    (sift :move
          {#"^react-highlight\.js.*[/ \\]dist[/ \\]main.js$"
           "cljsjs/react-highlight/development/react-highlight.inc.js"})
    (minify :in  "cljsjs/react-highlight/development/react-highlight.inc.js"
            :out "cljsjs/react-highlight/development/react-highlight.min.inc.js")
    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-highlight"
               :requires ["cljsjs.react"
                          "cljsjs.highlight"])
    (pom)
    (jar)))
