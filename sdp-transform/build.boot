(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "1.6.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/sdp
       :version     +version+
       :description "A simple parser/writer for the Session Description Protocol."
       :url         "https://github.com/clux/sdp-transform"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build-sdp []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap fileset
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "sdp-transform-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "browserify" "uglify-js"))
        ((sh "browserify" "lib/index.js" "--s" "sdp" "-o" "sdp.js"))
        ((sh "uglifyjs" "sdp.js" "-c" "-o" "sdp.min.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/clux/sdp-transform/archive/v%s.zip" +lib-version+)
             :checksum "CCBBFB377D6E6DD69E578F061C328D40"
             :unzip true)
   (build-sdp)
   (sift :move {#".*sdp\.js$"      "cljsjs/sdp/development/sdp.inc.js"
                #".*sdp\.min\.js$" "cljsjs/sdp/production/sdp.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.sdp")
   (pom)
   (jar)))
