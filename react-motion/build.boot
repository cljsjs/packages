(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react       "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.5.2")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-motion-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-motion
       :version     +version+
       :description "A spring that solves your animation problems."
       :url         "https://github.com/chenglou/react-motion"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-motion []
  (download :url      (format "https://github.com/chenglou/react-motion/archive/v%s.zip" +lib-version+)
            :checksum "426d31dd7502fdc141af7371a43f356a"
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
             (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
               ((sh "npm" "install"))
               ((sh "npm" "run" "prepublish")))
             (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-react-motion)
    (build-react-motion)
    (sift :move {#".*/build/react-motion\.js$"
                 "cljsjs/react-motion/development/react-motion.inc.js"})
    (minify :in "cljsjs/react-motion/development/react-motion.inc.js"
            :out "cljsjs/react-motion/production/react-motion.min.inc.js")
    (sift :include #{#"^cljsjs" #"^deps\.cljs"})
    (deps-cljs :provides ["react-motion" "cljsjs.react-motion"]
               :requires ["cljsjs.react"]
               :global-exports '{react-motion ReactMotion})
    (pom)
    (jar)
    (validate)))
