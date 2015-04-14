(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def codemirror-version "5.1.0")
(def +version+ (str codemirror-version "-0"))

(task-options!
  pom  {:project     'cljsjs/codemirror
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "Javascript syntax highlighter https://codemirror.net/"
        :url         "https://codemirror.net/"
        :license     {"MIT" "https://github.com/codemirror/CodeMirror/blob/master/LICENSE"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string]
         '[boot.util :refer [sh]]
         '[boot.tmpdir :as tmpd])

(deftask generate-mode-deps []
  (let [tmp (c/temp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->lang (fn [path] (second (re-matches #"cljsjs/codemirror/common/mode/(.*)\.inc\.js" path)))
        lang->foreign-lib (fn [lang]
                              {:file     (str "cljsjs/codemirror/common/mode/" lang ".inc.js")
                               :requires ["cljsjs.codemirror"]
                               :provides [(str "cljsjs.codemirror.mode." lang)]})]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
            mode-files         (->> fileset c/input-files (c/by-re [#"^cljsjs/codemirror/common/mode/.*\.inc\.js"]))
            modes              (map (comp lang->foreign-lib path->lang tmpd/path) mode-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat modes)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url (format "https://github.com/codemirror/CodeMirror/archive/%s.zip" codemirror-version)
              :unzip true
              :checksum "5471f9d6dca57a60721e2913ca6a3d96")
    (sift :move {#"^CodeMirror-([\d\.]*)/lib/codemirror\.js"      "cljsjs/codemirror/development/codemirror.inc.js"
                 #"^CodeMirror-([\d\.]*)/lib/codemirror\.css"     "cljsjs/codemirror/development/codemirror.css"
                 #"^CodeMirror-([\d\.]*)/mode/(.*)/(.*).js"       "cljsjs/codemirror/common/mode/$2.js"})
    (minify    :in       "cljsjs/codemirror/development/codemirror.inc.js"
               :out      "cljsjs/codemirror/production/codemirror.min.inc.js")
    (minify    :in       "cljsjs/codemirror/development/codemirror.css"
               :out      "cljsjs/codemirror/production/codemirror.min.css")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.codemirror")
    (sift :move {#"^cljsjs/codemirror/common/mode/(.*)\.js" "cljsjs/codemirror/common/mode/$1.inc.js"})
    (generate-mode-deps)))

