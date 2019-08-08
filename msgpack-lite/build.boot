(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.1.26")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/msgpack-lite
       :version     +version+
       :description "Fast pure JavaScript MessagePack encoder and decoder"
       :url         "https://github.com/kawanet/msgpack-lite"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-msgpack-lite []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "msgpack-lite-%s" +lib-version+)))]
        (dosh "npm" "install")
        (dosh "./node_modules/.bin/browserify" "--debug" "--standalone" "msgpack" "./lib/browser.js" "--outfile" "./dist/msgpack.browserify.js"))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (str "https://github.com/kawanet/msgpack-lite/archive/" +lib-version+ ".zip")
             :checksum "9a4005f8e6024b81c675cdf5c611dd98"
             :unzip true)
   (build-msgpack-lite)
   (sift :move {#"^msgpack-lite-.*/dist/msgpack\.browserify\.js" "cljsjs/msgpack-lite/development/msgpack-lite.inc.js"
                #"^msgpack-lite-.*/dist/msgpack\.min\.js"        "cljsjs/msgpack-lite/production/msgpack-lite.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.msgpack-lite")
   (pom)
   (jar)))
