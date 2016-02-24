(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react       "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.4.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-motion
       :version     +version+
       :description "A spring that solves your animation problems."
       :url         "https://github.com/chenglou/react-motion"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-motion []
  (download :url      (format "https://github.com/chenglou/react-motion/archive/v%s.zip" +lib-version+)
            :checksum "6795EBF517CC68AB8B8144057995AE2F"
            :unzip    true))

(deftask build-react-motion []
  (let [tmp (boot/tmp-dir!)]
           (with-pre-wrap
             fileset
             ;; Copy all files in fileset to temp directory
             (doseq [f (->> fileset boot/input-files)
                     :let [target (io/file tmp (tmpd/path f))]]
               (io/make-parents target)
               (io/copy (tmpd/file f) target))
             (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-motion-%s" +lib-version+)))]
               ;; Missing -f flag for rm in npm build, fails if lib/ does not exist or isn't empty
               ;; Already fixed in master, remove when updating to next release
               ((sh "mkdir" "lib"))
               ((sh "touch" "lib/foo"))
               ((sh "npm" "install"))
               ((sh "npm" "run" "prerelease")))
             (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-react-motion)
    (build-react-motion)
    (sift :move {#".*react-motion\.js$"
                 "cljsjs/react-motion/development/react-motion.inc.js"})
    (minify :in "cljsjs/react-motion/development/react-motion.inc.js"
            :out "cljsjs/react-motion/production/react-motion.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-motion"
               :requires ["cljsjs.react"])))
