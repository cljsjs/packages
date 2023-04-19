(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.3.2-0"]
                 [cljsjs/react-dom "16.3.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-autosize-textarea
       :version     +version+
       :description "A light replacement for built-in <textarea /> component which automatically adjusts its height to match the content."
       :url         "https://github.com/buildo/react-autosize-textarea/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.util :as util]
         '[clojure.java.io :as io])

(deftask build []
  (let [tmp          (c/tmp-dir!)
        +lib-folder+ (str "react-autosize-textarea-" +lib-version+)
        webpack-cfg  "webpack.config.dist.js"]
    (with-pre-wrap fileset
      (doseq [f    (c/input-files fileset)
              :let [target (io/file tmp (c/tmp-path f))]]
        (io/make-parents target)
        (io/copy (c/tmp-file f) target))
      (io/make-parents (io/file tmp +lib-folder+ "dist"))
      (io/copy
       (c/tmp-file (first (c/by-name [webpack-cfg] (c/input-files fileset))))
       (io/file tmp +lib-folder+ webpack-cfg))
      (binding [util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install" "--ignore-scripts"))
        ((sh "npm" "install" "--save-dev" "typescript@2.7.2 ts-loader@4.1.0 webpack-cli@4.4.1"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack.config.dist.js")))
      (-> fileset
          (c/add-resource (io/file tmp +lib-folder+ "dist"))
          c/commit!))))

(deftask package []
  (comp
   (download :url (str "https://github.com/buildo/react-autosize-textarea/archive/v" +lib-version+ ".zip")
             :unzip true)
   (build)
   (sift :move {#"^react-autosize-textarea\.js$"
                "cljsjs/react-autosize-textarea/development/react-autosize-textarea.inc.js"})
   (minify :in "cljsjs/react-autosize-textarea/development/react-autosize-textarea.inc.js"
           :out "cljsjs/react-autosize-textarea/production/react-autosize-textarea.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-autosize-textarea"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
