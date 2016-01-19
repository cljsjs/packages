(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.13.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-timer-mixin
       :version     +version+
       :description "TimerMixin provides timer functions for executing code in the future that are safely cleaned up when the component unmounts"
       :url         "https://github.com/reactjs/react-timer-mixin"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build-timer-mixin []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-timer-mixin-%s" +lib-version+)))]
        ((sh "npm" "install" "browserify"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "TimerMixin.js" "-s" "TimerMixin" "-o" "timerbundled.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/reactjs/react-timer-mixin/archive/v%s.zip" +lib-version+)
             :checksum "7b6973077e9e288ecfbdd2298ebcba70"
             :unzip true)
   (build-timer-mixin)
   (sift :move {#"^react(.*)/timerbundled.js"       "cljsjs/react-timer-mixin/development/TimerMixin.inc.js"})
   (minify :in "cljsjs/react-timer-mixin/development/TimerMixin.inc.js"
           :out "cljsjs/react-timer-mixin/production/TimerMixin.min.inc.js"
           :lang :ecmascript5)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-timer-mixin")))
