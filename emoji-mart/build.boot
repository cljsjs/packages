(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/emoji-mart
      :version     +version+
      :description "One component to pick them all 👊🏼"
      :scm         {:url "https://github.com/missive/emoji-mart"}
      :url         "https://missive.github.io/emoji-mart"})

(deftask download-emoji-mart []
  (download :url      (format "https://github.com/missive/emoji-mart/archive/v%s.zip" +lib-version+)
            :unzip    true))

(deftask build-emoji-mart []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "emoji-mart-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "run" "clean"))
        ((sh "npm" "run" "build:data"))
        ((sh "npm" "run" "build:dist"))
        ((sh "npm" "install" "browserify"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "--debug" "-u" "react" "dist/index.js" "-s" "EmojiMart" "-o" "dist/emoji-mart.js"))
        ((sh "sed" "-i.bak" "/var React = /d" "dist/emoji-mart.js"))
        ((sh "sed" "-i.bak" "s/var _react = .*/var _react = React;/" "dist/emoji-mart.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-emoji-mart)
   (build-emoji-mart)
   (sift :move {(re-pattern (str "^emoji-mart-" +lib-version+ "/dist/emoji-mart\\.js$")) "cljsjs/emoji-mart/development/emoji-mart.inc.js"
                (re-pattern (str "^emoji-mart-" +lib-version+ "/css/emoji-mart\\.css$")) "cljsjs/emoji-mart/common/emoji-mart.css"
                (re-pattern (str "^emoji-mart-" +lib-version+ "/LICENSE$")) "cljsjs/emoji-mart/common/LICENSE"})
   (minify :in  "cljsjs/emoji-mart/development/emoji-mart.inc.js"
           :out "cljsjs/emoji-mart/production/emoji-mart.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.emoji-mart")
   (pom)
   (jar)
   (validate)))