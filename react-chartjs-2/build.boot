(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]
                  [cljsjs/react "15.4.2-2"]
                  [cljsjs/chartjs "2.7.0-0"]])

(require '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :as util]
         '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[clojure.java.io :as io])

(def +lib-version+ "2.7.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-chartjs-2-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/react-chartjs-2
       :version     +version+
       :description "React wrapper for Chart.js"
       :url         "http://jerairrest.github.io/react-chartjs-2/"
       :scm         {:url "https://github.com/jerairrest/react-chartjs-2"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build []
  (let [tmp-file (boot/tmp-dir!)
        sh-dir (str (io/file tmp-file +lib-folder+))
        dist-file (io/file sh-dir "dist")]
    (with-pre-wrap
      fileset
      ;; copy unziped files into tmp
      (doseq [f (boot/input-files fileset)]
        (let [target (io/file tmp-file (tmpdir/path f))]
          (io/make-parents target)
          (io/copy (tmpdir/file f) target)))
      (binding [*sh-dir* sh-dir]
        ((sh "npm" "install"))
        ((sh "npm" "run" "build")))
      ;; copy dist into new tmp folder
      (-> fileset (boot/add-resource dist-file) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/jerairrest/react-chartjs-2/archive/%s.zip" +lib-version+)
             :unzip true)
   (build)
   (sift :move {#"^react-chartjs-2\.js"      "cljsjs/react-chartjs-2/development/react-chartjs-2.inc.js"
                #"^react-chartjs-2\.min\.js" "cljsjs/react-chartjs-2/production/react-chartjs-2.min.inc.js"})
   (deps-cljs :name "cljsjs.react-chartjs-2" :requires ["cljsjs.chartjs" "cljsjs.react" "cljsjs.react.dom"])
   (pom)
   (jar)))
