(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/jquery "1.9.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.8.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/flot
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "Attractive JavaScript plotting for jQuery"
        :url         "http://www.flotcharts.org/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        })

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask generate-plugin-deps []
  (let [tmp (c/temp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path-min->plugin (fn [path] (second (re-matches #"cljsjs/plugins/(.*)\.min\.inc\.js" path)))
        plugin->foreign-lib (fn [plugin]
                              {:file     (str "cljsjs/plugins/" plugin ".inc.js")
                               :file-min (str "cljsjs/plugins/" plugin ".min.inc.js")
                               :requires ["cljsjs.flot"]
                               :provides [(str "cljsjs.flot.plugins." plugin)]})]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file tmpd/file slurp read-string)
            ;; we enumerate all plugins by looking for minified files
            plugin-min-files   (->> fileset c/input-files (c/by-re [#"^cljsjs/plugins/.*\.min\.inc\.js"]))
            plugins            (map (comp plugin->foreign-lib path-min->plugin tmpd/path) plugin-min-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat plugins)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url (format "http://www.flotcharts.org/downloads/flot-%s.zip" +lib-version+)
              :checksum "a134a869d2b3d476a67a86abbe881676"
              :unzip true)

    (sift :move {#"flot/jquery\.flot\.js"            "cljsjs/development/flot.inc.js"
                 #"flot/jquery\.flot\.min\.js"       "cljsjs/production/flot.min.inc.js"})

    ; This is separate from the previous move task so flot.min.js isn't considered a plugin.
    ; And plugin files are not immediately named .inc.js as we don't want deps-cljs to find them.
    (sift :move {#"flot/jquery\.flot\.(.*)\.js" "cljsjs/plugins/$1.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.flot"
               :requires ["cljsjs.jquery"])

    (sift :move {#"^cljsjs/plugins/(.*)\.js" "cljsjs/plugins/$1.inc.js"})

    (generate-plugin-deps)
    (pom)
    (jar)))
