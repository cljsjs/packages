(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "3.1.7")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/redux
        :version     +version+
        :description "Redux is a predictable state container for JavaScript apps."
        :url         "https://github.com/rackt/redux"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask build-redux []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "redux-%s" +lib-version+)))]
         ((sh "npm" "install")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))
                          
(deftask package []
  (comp
    (download :url (str "https://github.com/rackt/redux/archive/v" +lib-version+ ".zip")
              :checksum "1BC034BD5624966803E0E36F2C6C52E3"
              :unzip true)
    (build-redux)

    (sift :move {#"^redux.*[/ \\]dist[/ \\]redux.js$" "cljsjs/redux/development/redux.inc.js"
                 #"^redux.*[/ \\]dist[/ \\]redux.min\.js$" "cljsjs/redux/production/redux.min.inc.js"
                 })

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.redux")))
