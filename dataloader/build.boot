(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "1.4.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "dataloader-%s" +lib-version+))

(task-options!
  pom {:project 'cljsjs/dataloader
       :version +version+
       :description "DataLoader is a generic utility to be used as part of your application's data fetching layer to provide a consistent API over various backends and reduce requests to those backends via batching and caching."
       :url "https://github.com/facebook/dataloader"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "https://opensource.org/licenses/MIT"}})

(def webpack-file-name "webpack.config.js")

(defn get-file [fileset file-name]
      (io/file
        (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
        file-name))

(deftask build-dataloader []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap fileset
                             (doseq [f (->> fileset boot/input-files)
                                     :let [target (io/file tmp (tmpd/path f))]]
                                    (io/make-parents target)
                                    (io/copy (tmpd/file f) target))
                             (io/copy (get-file fileset webpack-file-name)
                                      (io/file tmp +lib-folder+ webpack-file-name))
                             (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
                                      (do ((sh "npm" "install"))
                                          ((sh "npm" "install" "webpack"))
                                          ((sh "npm" "install" "webpack-cli"))
                                          ((sh "npm" "install" "babel-loader"))
                                          ((sh "npm" "install" "babel-preset-stage-0"))
                                          ((sh "./node_modules/.bin/webpack"))
                                          ((sh "./node_modules/.bin/webpack" "--env.production"))
                                          ((sh "rm" "-rf" "./node_modules"))))
                             (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
         (comp
           (download :url (format "https://github.com/facebook/dataloader/archive/v%s.zip" +lib-version+)
                     :checksum "CC8E0429946F27F5793C3B76825D3CEE"
                     :unzip true)
           (build-dataloader)
           (sift :move {#".*dataloader.inc.js"
                        "cljsjs/dataloader/development/dataloader.inc.js"
                        #".*dataloader.min.inc.js"
                        "cljsjs/dataloader/production/dataloader.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.dataloader"
                      :global-exports '{cljsjs.dataloader DataLoader})
           (pom)
           (jar)))
