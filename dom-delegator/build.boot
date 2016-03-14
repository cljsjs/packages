(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "13.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/dom-delegator
       :version     +version+
       :description "Decorate elements with delegated events"
       :url         "https://github.com/Raynos/dom-delegator"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build-dd []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "dom-delegator-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "browserify"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "index.js" "-s" "Delegator" "-o" "dom-delegator.inc.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/Raynos/dom-delegator/archive/v%s.zip" +lib-version+)
             :checksum "3C5F9FEA4446CBE9CC4F14BB0DA07B2A"
             :unzip true)

   (build-dd)
   (sift :move {#"^dom-delegator(.*)/dom-delegator.inc.js$" "cljsjs/dom-delegator/development/dom-delegator.inc.js"})
   (minify :in "cljsjs/dom-delegator/development/dom-delegator.inc.js"
           :out "cljsjs/dom-delegator/production/dom-delegator.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dom-delegator")
   (pom)
   (jar)))
