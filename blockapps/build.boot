(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "2.2.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/blockapps
       :version     +version+
       :description "Interface to the Ethereum blockchain providing contract creation and transactions, state inspection, and dApp registration and management"
       :url         "https://github.com/blockapps/blockapps-js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build-blockapps []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "blockapps-js-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "run" "browserify"))
        ((sh "npm" "run" "minify")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/blockapps/blockapps-js/archive/v%s.zip" +lib-version+)
             :checksum "7DB3DD2F309F61D4E277437350C7F5CA"
             :unzip true)
   (build-blockapps)
   (sift :move {#".*blockapps\.js$"       "cljsjs/blockapps/development/blockapps.inc.js"
                #".*blockapps-min\.js$"   "cljsjs/blockapps/production/blockapps.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.blockapps")
   (pom)
   (jar)))
