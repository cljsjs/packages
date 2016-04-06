(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.6.38")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/forge
       :version     +version+
       :description "A native implementation of TLS in Javascript and tools to write crypto-based and network-heavy webapps."
       :url         "https://github.com/digitalbazaar/forge"
       :scm         {:url "https://github.com/digitalbazaar/forge"}})

(deftask build-forge []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "forge-%s" +lib-version+)))]
        (do ((sh "npm" "install"))
            ((sh "npm" "run" "bundle"))))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
  (comp
   (download :url (str "https://github.com/digitalbazaar/forge/archive/" +lib-version+ ".zip")
             :checksum "82ea500a3bfd5a76749dad68051d3118"
             :unzip true)
   (build-forge)
   (sift :move {#"^forge-[^/]*/js/forge.bundle.js" "cljsjs/forge/development/forge.inc.js"})
   (minify :in "cljsjs/forge/development/forge.inc.js"
           :out "cljsjs/forge/production/forge.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.forge")
   (pom)
   (jar)))
