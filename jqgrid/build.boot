(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/jquery    "2.1.4-0"]
                  [cljsjs/jquery-ui "1.11.3-1"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/jqgrid
        :version     +version+
        :description "jqGrid plugin for jQuery"
        :url         "http://www.trirand.com/blog"
        :license     {"Multiple" "http://www.trirand.com/blog/?page_id=400"}
        :scm         {:url "https://github.com/tonytomov/jqGrid"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string]
         '[boot.util :refer [sh]]
         '[boot.tmpdir :as tmpd])

(deftask generate-lang-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->lang (fn [path] (second (re-matches #"cljsjs/jqgrid/common/(.*)\.inc\.js" path)))
        lang->foreign-lib (fn [lang]
                              {:file     (str "cljsjs/jqgrid/common/" lang ".inc.js")
                               :requires ["cljsjs.jqgrid"]
                               :provides [(str "cljsjs.jqgrid.langs." lang)]})]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
            lang-files         (->> fileset c/input-files (c/by-re [#"^cljsjs/jqgrid/common/.*\.inc\.js"]))
            langs              (map (comp lang->foreign-lib path->lang tmpd/path) lang-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat langs)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
   (download :url (format "https://github.com/tonytomov/jqGrid/archive/v%s.zip" +lib-version+)
             :checksum "05e55300839c6df60360b68ea75fccf2"
             :unzip true)
   (sift :move {#"^jqGrid-([\d\.]*)/js/jquery\.jqGrid\.js" "cljsjs/jqgrid/development/jqgrid.inc.js"
                #"^jqGrid-([\d\.]*)/js/minified/jquery\.jqGrid\.min\.js" "cljsjs/jqgrid/production/jqgrid.min.inc.js"})
   (deps-cljs :name "cljsjs.jqgrid" :requires ["cljsjs.jquery" "cljsjs.jquery-ui"])
   (sift :move {#"^jqGrid-([\d\.]*)/js/i18n/(.*).js" "cljsjs/jqgrid/common/$2.inc.js"})
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
   (generate-lang-deps)
   (pom)
   (jar)))
