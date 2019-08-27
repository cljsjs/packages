(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +sha-short-version+ "b92eff3")
(def +sha-version+ "b92eff3d68a9af14b8ee4c11e98fde02686e184a")
(def +lib-version+ "0.3.6")
(def +version+ (str +lib-version+ "-2"))

(task-options!
 pom {:project     'cljsjs/emojione-picker
      :version     +version+
      :description "A react emoji picker for use with emojione"
      :scm         {:url "https://github.com/tommoor/emojione-picker"}
      :url         "http://tommoor.github.io/emojione-picker"})

(deftask download-emojione-picker []
  (download :url      (format "https://github.com/tommoor/emojione-picker/archive/%s.zip" +sha-version+)
            :unzip    true))

(deftask build-emojione-picker []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "emojione-picker-%s" +sha-version+)))]
        ((sh "mkdir" "dist"))
        ((sh "npm" "install"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "--debug" "-u" "react" "lib/picker.js" "-s" "EmojionePicker" "-o" "dist/emojione-picker.js"))
        ((sh "sed" "-i.bak" "/var React = /d" "dist/emojione-picker.js"))
        ((sh "sed" "-i.bak" "s/var _react = .*/var _react = React;/" "dist/emojione-picker.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-emojione-picker)
   (build-emojione-picker)
   (sift :move {(re-pattern (str "^emojione-picker-" +sha-version+ "/dist/emojione-picker\\.js$")) "cljsjs/emojione-picker/development/emojione-picker.inc.js"
                (re-pattern (str "^emojione-picker-" +sha-version+ "/css/picker\\.css$")) "cljsjs/emojione-picker/common/emojione-picker.css"})
   (minify :in  "cljsjs/emojione-picker/development/emojione-picker.inc.js"
           :out "cljsjs/emojione-picker/production/emojione-picker.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.emojione-picker")
   (pom)
   (jar)))