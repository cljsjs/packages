(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.1.8")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "absinthe-socket--absinthe-socket-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/absinthe-socket
       :version     +version+
       :description "Core JavaScript support for Absinthe WS-based operations"
       :url         "https://github.com/absinthe-graphql/absinthe-socket"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-absinthe-socket []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (io/copy
       (io/file tmp "rollup.config.js")
       (io/file tmp +lib-folder+ "rollup-cljsjs.config.js"))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "rollup"))
        ((sh (str (io/file tmp +lib-folder+ "node_modules" ".bin" "rollup")) "-c" "rollup-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/absinthe-graphql/absinthe-socket/archive/@absinthe/socket@%s.zip" +lib-version+)
             :unzip true)
   (build-absinthe-socket)
   (sift :move {#"^absinthe-socket--.*/umd/index\.js" "cljsjs/absinthe-socket/development/absinthe-socket.inc.js"
                #"^absinthe-socket--.*/umd/index\.js" "cljsjs/absinthe-socket/production/absinthe-socket.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.absinthe-socket")
   (pom)
   (jar)
   (validate-checksums)))
