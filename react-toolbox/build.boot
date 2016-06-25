(set-env!
  :resource-paths #{"resources"}
  :dependencies '[
                  [cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/react-with-addons "15.1.0-0"]
                  ])

(require
  '[cljsjs.boot-cljsjs.packaging :refer [download deps-cljs]]
  '[boot.core :as boot]
  '[clojure.java.io :as io]
  '[boot.util :as util]
  )

(def +lib-version+ "1.0.1")
(def +lib-folder+ (format "react-toolbox-%s" +lib-version+))
(def +version+ (str +lib-version+ "-0"))
(def url (format "https://github.com/react-toolbox/react-toolbox/archive/%s.zip" +lib-version+))

(def webpack-file-name "webpack.config.boot.js")

(task-options!
  pom {:project 'cljsjs/react-toolbox
       :version +version+
       :description "A set of React components implementing Google's Material Design specification with the power of CSS Modules."
       :url "http://react-toolbox.com/"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}
       })

(deftask download-react-toolbox []
  (download :url url
            :unzip true))

(defn- get-file [fileset file-name]
  (io/file
    (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
    file-name))

(deftask build-react-toolbox []
  (let [tmp (boot/tmp-dir!)]
    (boot/with-pre-wrap fileset
      (let [files (boot/input-files fileset)
            lib (boot/by-re [(re-pattern (str +lib-folder+ "/lib/*"))] files)
            webpack (first (boot/by-name [webpack-file-name] files))]

        ;; move files into fileset
        (doseq [f files]
          (let [in-file (boot/tmp-file f)
                target (io/file tmp (boot/tmp-path f))]
            (io/make-parents target)
            (io/copy in-file target)))

        ;; move webpack config into lib
        (io/copy (boot/tmp-file webpack)
                 (io/file tmp +lib-folder+ webpack-file-name))

        ;; use webpack to construct artifacts
        (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
          (do
            ((sh "npm" "install"))
            ((sh "./node_modules/.bin/webpack" "--config" (str "./" webpack-file-name)))
            ((sh "./node_modules/.bin/webpack" "--production" "--config"  (str "./" webpack-file-name))))))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-react-toolbox)
    (build-react-toolbox)
    (sift :move {#".*index.inc.js"
                 "cljsjs/react-toolbox/development/react-toolbox.inc.js"

                 #".*index.min.inc.js"
                 "cljsjs/react-toolbox/production/react-toolbox.min.inc.js"
                 })
    (sift :include #{#"^cljsjs/" #"^deps.cljs$"})
    (deps-cljs :name "cljsjs.react-toolbox")
    (pom)
    (jar)))

(deftask local []
  (comp
    (package)
    (install)))
