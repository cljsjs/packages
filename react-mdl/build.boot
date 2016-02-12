(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh info]]
         '[boot.task-helpers :as helpers])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-mdl
       :version     +version+
       :description "React Components wrapper for Material Design Lite UI http://tleunen.github.io/react-mdl/"
       :url         "http://tleunen.github.io/react-mdl/"
       :scm         {:url "https://github.com/tleunen/react-mdl"}})

(deftask build-react-mdl []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-mdl-%s" +lib-version+)))]
        (do ((sh "npm" "install"))
            ((sh "npm" "run" "prebuild-all"))
            ((sh "npm" "run" "build-all"))))
      (-> fileset (boot/add-resource tmp) boot/commit!)))  )

(deftask package []
  (comp
   (download :url (str "https://github.com/tleunen/react-mdl/archive/v" +lib-version+ ".zip")
             :checksum "d79400004f7042194caffeb1065af6e9"
             :unzip true)

   (sift :move {#"^react-mdl[^/]*/extra/material.js"       "cljsjs/react-mdl/development/material.inc.js"
                #"^react-mdl[^/]*/extra/material.css"      "cljsjs/react-mdl/development/material.css"

                #"^react-mdl[^/]*/extra/material.min.js"   "cljsjs/react-mdl/production/material.min.inc.js"
                #"^react-mdl[^/]*/extra/material.min.css"  "cljsjs/react-mdl/production/material.min.css"})

   (minify :in "cljsjs/react-mdl/production/material.min.inc.js"
           :out "cljsjs/react-mdl/production/material.min.inc.js")
   (sift :include #{#"^cljsjs"})

   (deps-cljs :name     "cljsjs.react-mdl"
              :requires ["cljsjs.react"])))
