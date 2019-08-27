(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react       "15.1.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.17.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/radium
       :version     +version+
       :description "A toolchain for React component styling."
       :url         "https://github.com/FormidableLabs/radium"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-radium []
  (download :url      (format "https://github.com/FormidableLabs/radium/archive/v%s.zip" +lib-version+)
            :checksum "38fe1ee3e9ecf58b246a8a2b55a10fc6"
            :unzip    true))

(deftask build-radium []
  (let [tmp (boot/tmp-dir!)]
           (with-pre-wrap
             fileset
             ;; Copy all files in fileset to temp directory
             (doseq [f (->> fileset boot/input-files)
                     :let [target (io/file tmp (tmpd/path f))]]
               (io/make-parents target)
               (io/copy (tmpd/file f) target))
             (binding [boot.util/*sh-dir* (str (io/file tmp (format "radium-%s" +lib-version+)))]
               ((sh "npm" "install" "--ignore-scripts"))
               ((sh "npm" "run" "dist")))
             (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-radium)
    (build-radium)
    (sift :move {#"^radium-(.*)/dist/radium.js$"
                 "cljsjs/radium/development/radium.inc.js"})
    (sift :move {#"^radium-(.*)/dist/radium.min.js$"
                 "cljsjs/radium/production/radium.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.radium"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
