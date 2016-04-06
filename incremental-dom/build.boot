(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/incremental-dom
      :version +version+
      :description "Dom-building library from google"
      :url "http://github.com/google/incremental-dom"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache 2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask build-incremental-dom []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))

      (binding [boot.util/*sh-dir* (str (io/file tmp (format "incremental-dom-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "patch" "gulpfile.js" "../gulpfile.js.patch" "-o" "patched-gulpfile.js"))
        ((sh "./node_modules/.bin/gulp" "--gulpfile=patched-gulpfile.js" "js-closure-provides")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))


(deftask package []
  (comp
   (download :url (format "https://github.com/google/incremental-dom/archive/%s.zip" +lib-version+)
             :checksum "170A1C354379FF2AF3A08455BFB0AD9D"
             :unzip true)
   (build-incremental-dom)
   (sift :move {#"^incremental-dom-(.*)/dist/incremental-dom-closure-provides.js"
                "cljsjs/incremental-dom/development/incremental-dom.js"})
   (sift :include #{#"^cljsjs/" #"deps.cljs"})
   (pom)
   (jar)))
