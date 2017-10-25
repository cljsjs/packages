(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.12.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/highlight
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "JavaScript syntax highlighter"
        :url         "https://highlightjs.org/"
        :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(require '[boot.core :as c]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(deftask generate-lang-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->lang (fn [path] (second (re-matches #"cljsjs/common/highlight/(.*)\.inc\.js" path)))
        lang->foreign-lib (fn [lang]
                              {:file     (str "cljsjs/common/highlight/" lang ".inc.js")
                               :requires ["cljsjs.highlight"]
                               :provides [(str "cljsjs.highlight.langs." lang)]})]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file c/tmp-file slurp read-string)
            lang-files         (->> fileset c/input-files (c/by-re [#"^cljsjs/common/highlight/.*\.inc\.js"]))
            langs              (map (comp lang->foreign-lib path->lang c/tmp-path) lang-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat langs)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask build-highlightjs []
  (let [tmp (c/tmp-dir!)]
    (with-pre-wrap
      fileset
      ; Copy all files in fileset to temp directory
      (doseq [f (->> fileset c/input-files)
              :let [target  (io/file tmp (c/tmp-path f))]]
        (io/make-parents target)
        (io/copy (c/tmp-file f) target))
      (binding [boot.util/*sh-dir* (str tmp)]
        ((sh "npm" "install"))
        ((sh "node" "tools/build.js" "-t" "cdn" ":none")))
      (-> fileset (c/add-resource tmp) c/commit!))))

(deftask package []
  (comp
    (download :url (format "https://github.com/isagalaev/highlight.js/archive/%s.zip" +lib-version+)
              :unzip true
              :checksum "BDFA4E9FE609772C4589058D30A08894")
    (sift :move {#"^highlight\.js-\d*\.\d*.\d*/" ""})
    (build-highlightjs)
    (sift :move {#"build/highlight\.min\.js" "cljsjs/common/highlight.inc.js"})
    (deps-cljs :name "cljsjs.highlight")
    (sift :move {#"build/languages/(.*)\.min\.js" "cljsjs/common/highlight/$1.inc.js"
                 #"build/styles/(.*)\.css" "cljsjs/common/highlight/$1.css"})
    (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
    (generate-lang-deps)
    (pom)
    (jar)))
