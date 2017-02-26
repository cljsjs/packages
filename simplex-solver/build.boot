(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]]
         '[clojure.string :as string])

(def +lib-version+ "0.0.3")
(def +version+ (str +lib-version+ "-0"))
(def +commit-id+ "8e55b56d499dc7d64ac22a5051f2eeb4a22a2534")
(def +src-url+ "https://github.com/SamDuvall/simplex-solver")
(def +lib-folder+ (format "simplex-solver-%s" +commit-id+))

(task-options!
 pom  {:project     'cljsjs/simplex-solver
       :version     +version+
       :description "A Simple Simplex Solver"
       :url         +src-url+
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-solver []
  (let [url (str +src-url+ "/archive/" +commit-id+ ".zip")
        checksum "7f208d870705db50014fefb8f9b48731"]
    (download :url url
              :checksum checksum
              :unzip true)))

(deftask build []
  (let [tmp (boot/tmp-dir!)
        tmp-lib (str tmp "/" +lib-folder+)]
    (with-pre-wrap
      fileset
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp (tmpd/path f))]
          (io/make-parents target)
          (io/copy (tmpd/file f) target)))
      (io/copy
        (io/file "resources/simplex-solver.inc.js")
        (io/file (str tmp-lib) "simplex-solver.inc.js"))
      (spit (str tmp-lib "/gulpfile.js")
        (str "\n" (slurp "resources/simplex-lib-gulp-task.js")) :append true)
      (binding [*sh-dir* (str (io/file tmp-lib))]
        ((sh "npm" "install"))
        ((sh "gulp" "js-lib")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-solver)
   (build)
   (sift :move {#"^simplex-solver.*[/ \\]dist[/ \\]lib[/ \\]simplex-solver.inc.js$"
     "cljsjs/simplex-solver/common/simplex-solver.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.simplex-solver")
   (pom)
   (jar)))
