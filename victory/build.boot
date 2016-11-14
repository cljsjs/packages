(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                 [cljsjs/react "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.13.7")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "victory.js-%s" +lib-version+))

(task-options!
 pom { :project     'cljsjs/victory
      :version     +version+
      :description "victory.js collection of composable React components for building interactive data visualizations"
      :url         "http://victory.formidable.com"
      :scm         { :url "https://github.com/FormidableLabs/victory" }
      :license     { "MIT" "https://github.com/FormidableLabs/victory/blob/master/LICENSE.txt" }})

(deftask build-victory []
  (let [tmp (tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (->> fileset input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp))]
        (do ((sh "npm" "install"))
            ((sh "npm" "install" "webpack"))
            ((sh "npm" "install" "babel-core"))
            ((sh "npm" "install" "babel-loader"))
            ((sh "npm" "install" "victory"))
            ;; TODO: change --output-file to --output once flag is available
            ((sh "node_modules/.bin/webpack" "-d"
                 "--config" "webpack.config.js"
                 "--output-file" "dist/bundle-dev.js"))
            ((sh "node_modules/.bin/webpack" "-p"
                 "--config" "webpack.config.js"
                 "--output-file" "dist/bundle.js"))))
      (-> fileset (add-resource tmp) commit!))))

(deftask package []
  (comp

   (build-victory)

   (sift :move {#"^dist/bundle-dev.js"  "cljsjs/victory/development/victory.inc.js"
                #"^dist/bundle-dev.map" "cljsjs/victory/development/victory.inc.map"
                #"^dist/bundle.js"      "cljsjs/victory/production/victory.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.victory"
              :requires ["cljsjs.react"])

   (pom)
   (jar)))
