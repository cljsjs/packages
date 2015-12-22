(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/bitauth
       :version     +version+
       :description "Authenticate with web services utilizing the same strategy as Bitcoin"
       :url         "https://github.com/bitpay/bitauth"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build-bitauth []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "bitauth-%s" +lib-version+)))]
        ((sh "npm" "install")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/bitpay/bitauth/archive/v%s.zip" +lib-version+)
             :checksum "019e001be682f4ca39b6924b91555765"
             :unzip true)
   (build-bitauth)
   (sift :move {#".*dist/bitauth\.bundle\.js"       "cljsjs/bitauth/development/bitauth.inc.js"
                #".*dist/bitauth\.browser\.min\.js" "cljsjs/bitauth/production/bitauth.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.bitauth")))
