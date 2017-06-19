(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.12")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/highcharts
       :version     +version+
       :description "Create interactive charts easily for your web projects."
       :url         "http://highcharts.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(def files
  ["highcharts" "highcharts-more" "highcharts-3d" "modules/accessibility"
   "modules/annotations" "modules/boost" "modules/broken-axis"
   ;; canvas-tools is not part of latest release
   ;; looks like it was last included in v4.2.7 so maybe it is deprecated?
   ; "modules/canvas-tools"
   "modules/data" "modules/exporting"
   "modules/drilldown" "modules/funnel" "modules/heatmap"
   "modules/no-data-to-display" "modules/offline-exporting"
   "modules/solid-gauge" "modules/treemap"])

(require '[boot.core :as c]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(defn path->foreign-lib [path]
  (if (not= "cljsjs/highcharts/development/highcharts.js" path)
    {:file-min path
     :file (-> path
               (string/replace #"\.js$" ".min.js")
               (string/replace #"/development/" "/production/"))
     :requires ["cljsjs.highcharts"]
     :provides [(-> path
                    (string/replace #"\.js$" "")
                    (string/replace #"/development/" "/")
                    (string/replace #"/" "."))]}))

(deftask generate-extra-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file c/tmp-file slurp read-string)
            extra-files        (->> fileset c/input-files (c/by-re [#"^cljsjs/highcharts/development/(.*/)?.*\.js$"]))
            foreign-libs       (keep identity (map (comp path->foreign-lib c/tmp-path) extra-files))
            new-deps           (update-in existing-deps [:foreign-libs] concat foreign-libs)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url (format "https://code.highcharts.com/zips/Highcharts-%s.zip" +lib-version+)
              :checksum "0402F6D3ADD60DAAA8D8B87643784C2A"
              :unzip true)
    (target)
    (sift :move {
                 #"^code/highcharts\.js$"      "cljsjs/highcharts/production/highcharts.min.inc.js"
                 #"^code/highcharts\.src\.js$" "cljsjs/highcharts/development/highcharts.inc.js"
                 #"^code/([^/\.]*)\.js$"      "cljsjs/highcharts/production/$1.min.js"
                 #"^code/([^/\.]*)\.src\.js$" "cljsjs/highcharts/development/$1.js"
                 #"^code/modules/([^/\.]*)\.js$"      "cljsjs/highcharts/production/modules/$1.min.js"
                 #"^code/modules/([^/\.]*)\.src\.js$" "cljsjs/highcharts/development/modules/$1.js"})
    (target)
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.highcharts")
    (generate-extra-deps)
    (pom)
    (jar)))
