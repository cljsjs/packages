(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/prop-types "15.6.0-0"]
                 [cljsjs/react "16.0.0-0"]
                 [cljsjs/react-dom "16.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-meta-tags
       :version     +version+
       :description "Handle document meta/head tags in isomorphic react with ease."
       :url         "https://github.com/s-yadav/react-meta-tags"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-meta-tags []
  (download
   :url (str "https://github.com/s-yadav/react-meta-tags/archive/v" +lib-version+ ".zip")
   :checksum "252026c0c394e037b6f1e7c99efe0051"
   :unzip true))

(deftask build-meta-tags []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-meta-tags-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "run" "bundle")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-meta-tags)
   (build-meta-tags)
   (sift :move {#"^react-meta-tags.*[/ \\]dist[/ \\]react-meta-tags.js$" "cljsjs/react-meta-tags/development/react-meta-tags.inc.js"
                #"^react-meta-tags.*[/ \\]dist[/ \\]react-meta-tags.min\.js$" "cljsjs/react-meta-tags/production/react-meta-tags.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-meta-tags"
              :requires ["cljsjs.prop-types"
                         "cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)))
