(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]]
         '[clojure.string :as str])

(def +lib-version+ "3.5.1")
(def +version+ (str +lib-version+ "-0"))
(def +expected-checksum+ "785C6BD4D021C6469006FE2993A43F20")

(task-options!
  pom  {:project     'cljsjs/react-autosuggest
        :version     +version+
        :description "WAI-ARIA compliant React autosuggest component "
        :url         "https://github.com/moroshko/react-autosuggest.git"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-autosuggest  []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (let [build-dir  (str (io/file tmp (format "react-autosuggest-%s" +lib-version+)))]
        (binding [boot.util/*sh-dir* build-dir]
          ((sh "npm" "install"))))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
  (comp
    (download :url (str "https://github.com/moroshko/react-autosuggest/archive/v" +lib-version+ ".zip")
              :checksum +expected-checksum+
              :unzip true) 
    (build-autosuggest)

    (sift :move {#"^react-autosuggest.*[/ \\]dist[/ \\]standalone[/ \\]autosuggest.js$" "cljsjs/react-autosuggest/development/react-autosuggest.inc.js"
                 #"^react-autosuggest.*[/ \\]dist[/ \\]standalone[/ \\]autosuggest.min\.js$" "cljsjs/react-autosuggest/production/react-autosuggest.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-autosuggest"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)
    (jar)))

