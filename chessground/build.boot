(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/merge "1.2.0-0"]
                 [cljsjs/mithril "1.0.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "4.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/chessground
       :version     +version+
       :description "Mobile/Web chess UI built with mithril.js, for lichess.org http://lichess.org"
       :url         "https://github.com/ornicar/chessground/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})


(deftask build-chessground []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))

      (binding [boot.util/*sh-dir* (str (io/file tmp (format "chessground-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "patch" "gulpfile.js" "../gulpfile.js.patch" "-o" "patched-gulpfile.js"))
        ((sh "./node_modules/.bin/gulp" "--gulpfile=patched-gulpfile.js" "dev-noblock")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/ornicar/chessground/archive/v%s.zip" +lib-version+)
             :checksum "de70e03ac9ce55a03439b230f4967053"
             :unzip true)
   (build-chessground)
   (sift :move {#"^chessground-.*/chessground\.js" "cljsjs/chessground/development/chessground.inc.js"})
   (sift :move {#"^chessground-.*/chessground\.min\.js" "cljsjs/chessground/production/chessground.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.chessground"
              :requires ["cljsjs.merge" "cljsjs.mithril"])
   (show :fileset true)
   (pom)
   (jar)))

