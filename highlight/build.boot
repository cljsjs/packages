(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "8.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/highlight
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "Javascript syntax highlighter"
        :url         "https://highlightjs.org/"
        :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string]
         '[boot.util :refer [sh]]
         '[boot.tmpdir :as tmpd])

(deftask generate-lang-deps []
  (let [tmp (c/temp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->lang (fn [path] (second (re-matches #"cljsjs/common/highlight/(.*)\.inc\.js" path)))
        lang->foreign-lib (fn [lang]
                              {:file     (str "cljsjs/common/highlight/" lang ".inc.js")
                               :requires ["cljsjs.highlight"]
                               :provides [(str "cljsjs.highlight.langs." lang)]})]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
            lang-files         (->> fileset c/input-files (c/by-re [#"^cljsjs/common/highlight/.*\.inc\.js"]))
            langs              (map (comp lang->foreign-lib path->lang tmpd/path) lang-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat langs)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask build-highlightjs []
  (let [tmp (c/temp-dir!)]
    (with-pre-wrap
      fileset
      ; Copy all files in fileset to temp directory
      (doseq [f (->> fileset c/input-files)
              :let [target  (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str tmp)]
        ((sh "npm" "install"))
        ((sh "node" "tools/build.js" "-t" "cdn" ":none")))
      (-> fileset (c/add-resource tmp) c/commit!))))

(deftask package []
  (comp
    (download :url (format "https://github.com/isagalaev/highlight.js/archive/%s.zip" +lib-version+)
              :unzip true
              :checksum "2CAC2669F0D1AD1E384543059F10F8F8")
    (sift :move {#"^highlight\.js-\d?\.\d?/" ""})
    (build-highlightjs)
    (sift :move {#"build/highlight\.min\.js" "cljsjs/common/highlight.inc.js"})
    (deps-cljs :name "cljsjs.highlight")
    (sift :move {#"build/languages/(.*)\.min\.js" "cljsjs/common/highlight/$1.inc.js"
                 #"build/styles/(.*)\.css" "cljsjs/common/highlight/$1.css"})
    (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
    (generate-lang-deps)
    (pom)
    (jar)))

