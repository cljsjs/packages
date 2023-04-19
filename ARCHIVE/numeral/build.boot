(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/numeral
        :version     +version+
        :description "A javascript library for formatting and manipulating numbers."
        :url         "http://numeraljs.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/adamwdraper/Numeral-js"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask generate-locale-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->locale-ns (fn [path] (second (re-matches #"cljsjs/numeral/common/locales/(.*)\.inc\.js" path)))
        path->foreign-lib (fn [path]
                            {:file path
                             :requires ["cljsjs.numeral"]
                             :provides [(format "cljsjs.numeral.locales.%s" (path->locale-ns path))]})]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
            locale-files       (->> fileset c/input-files (c/by-re [#"^cljsjs/numeral/common/locales/.*"]) (c/by-ext [".inc.js"]))
            locales            (map (comp path->foreign-lib tmpd/path) locale-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat locales)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url (format "https://github.com/adamwdraper/Numeral-js/archive/%s.zip" +lib-version+)
              :checksum "eb34d08bbc41b15526d3bdc09902715d"
              :unzip true)
    ; Locale files are not immediately named .inc.js as we don't want deps-cljs to find them
    (sift :move {#"^Numeral.*/numeral.js" "cljsjs/numeral/development/numeral.inc.js"
                 #"^Numeral.*/min/numeral.min.js" "cljsjs/numeral/production/numeral.min.inc.js"
                 #"^Numeral.*/locales/(.*)\.js"     "cljsjs/numeral/common/locales/$1.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.numeral")
    (sift :move {#"^cljsjs/numeral/common/locales/(.*)\.js" "cljsjs/numeral/common/locales/$1.inc.js"})
    (generate-locale-deps)
    (pom)
    (jar)))
