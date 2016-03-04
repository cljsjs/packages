(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh info]]
         '[boot.task-helpers :as helpers])

(def +lib-version+ "1.4.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-mdl-extra
       :version     +version+
       :description "Deps for React Components wrapper for Material Design Lite UI http://tleunen.github.io/react-mdl/"
       :url         "http://tleunen.github.io/react-mdl/"
       :scm         {:url "https://github.com/tleunen/react-mdl"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/tleunen/react-mdl/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^react-mdl[^/]*/extra/material.js"       "cljsjs/react-mdl/development/material.inc.js"
                #"^react-mdl[^/]*/extra/material.css"      "cljsjs/react-mdl/development/material.css"

                #"^react-mdl[^/]*/extra/material.min.js"   "cljsjs/react-mdl/production/material.min.inc.js"
                #"^react-mdl[^/]*/extra/material.min.css"  "cljsjs/react-mdl/production/material.min.css"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-mdl-extra")))
