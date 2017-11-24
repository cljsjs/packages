(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-autosize-textarea
       :version     +version+
       :description "A textarea perfectly compatible with ReactJS default one
                     which auto resizes its height based on user input."
       :url         "https://github.com/buildo/react-autosize-textarea/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.util :as util]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

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
        ((sh "npm" "install" "--save-dev" "webpack@2.2.1"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack.config.dist.js")))

      (-> fileset
          (c/add-resource (io/file tmp +lib-folder+ "dist"))
          c/commit!))))

(deftask package []
  (comp
   (download :url (str "https://github.com/buildo/react-autosize-textarea/archive/v" +lib-version+ ".zip")
             :checksum "4302387B4BEDF9109B868BC642F39FB2"
             :unzip true)
   (build)

   (sift :move {#"^react-autosize-textarea\.js$"
                "cljsjs/react-autosize-textarea/development/react-autosize-textarea.inc.js"})

   (minify :in "cljsjs/react-autosize-textarea/development/react-autosize-textarea.inc.js"
           :out "cljsjs/react-autosize-textarea/production/react-autosize-textarea.min.inc.js")

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-autosize-textarea"
              :requires ["cljsjs.react"])
   (pom)
   (jar)))
