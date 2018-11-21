(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.22.2")
(def +version+ (str +lib-version+ "-2"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/moment
       :version     +version+
       :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
       :url         "http://momentjs.com/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask generate-locale-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->locale-ns (fn [path] (second (re-matches #"cljsjs/common/locale/(.*)\.inc\.js" path)))
        path->foreign-lib (fn [path]
                            (let [locale-ns (path->locale-ns path)
                                  moment-ns (format "moment.locale.%s" locale-ns)
                                  cljsjs-moment-ns (format "cljsjs.moment.locale.%s" locale-ns)]
                              {:file path
                               :requires ["moment"]
                               :provides [moment-ns cljsjs-moment-ns]}))]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
            locale-files       (->> fileset c/input-files (c/by-re [#"^cljsjs/common/locale/.*"]) (c/by-ext [".inc.js"]))
            locales            (map (comp path->foreign-lib tmpd/path) locale-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat locales)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
   (download :url (format "https://github.com/moment/moment/archive/%s.zip" +lib-version+)
             :unzip true)
                                        ; Locale files are not immediately named .inc.js as we don't want deps-cljs to find them
   (sift :move {#"^moment-[^\/]*/moment\.js"          "cljsjs/development/moment.inc.js"
                #"^moment-[^\/]*/min/moment\.min\.js" "cljsjs/production/moment.min.inc.js"
                #"^moment-[^\/]*/locale/(.*)\.js"     "cljsjs/common/locale/$1.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs
    :provides ["moment" "cljsjs.moment"]
    :global-exports '{moment moment})
   (sift :move {#"^cljsjs/common/locale/(.*)\.js" "cljsjs/common/locale/$1.inc.js"})
   (generate-locale-deps)
   (pom)
   (jar)
   (validate)))
