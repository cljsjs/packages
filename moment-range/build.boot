(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.0.3")
(bootlaces! +version+)

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/moment-range
        :version     +version+
        :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
        :url         "http://gf3.github.io/moment-range/"
        :license     {"UNLICENSED" "http://unlicense.org/"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

;; (deftask generate-locale-deps []
;;   (let [tmp (c/tmp-dir!)
;;         new-deps-file (io/file tmp "deps.cljs")
;;         path->locale-ns (fn [path] (second (re-matches #"cljsjs/common/locale/(.*)\.inc\.js" path)))
;;         path->foreign-lib (fn [path]
;;                             {:file path
;;                              :requires ["cljsjs.moment"]
;;                              :provides [(format "cljsjs.moment.locale.%s" (path->locale-ns path))]})]
;;     (with-pre-wrap
;;       fileset
;;       (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
;;             existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
;;             locale-files       (->> fileset c/input-files (c/by-re [#"^cljsjs/common/locale/.*"]) (c/by-ext [".inc.js"]))
;;             locales            (map (comp path->foreign-lib tmpd/path) locale-files)
;;             new-deps           (update-in existing-deps [:foreign-libs] concat locales)]
;;         (spit new-deps-file (pr-str new-deps))
;;         (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url "https://github.com/gf3/moment-range/archive/2.0.3.zip"
              :checksum "705f4467371c7c3a442d0dbc573fe073"
              :unzip true)

    (sift :move {#"^moment-range.*/dist/moment-range\.js"          "cljsjs/development/moment-range.inc.js"
                 #"^moment-range.*/dist/moment-range\.min\.js"     "cljsjs/production/moment-range.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.moment-range")
    ;;(generate-locale-deps)
    ))
