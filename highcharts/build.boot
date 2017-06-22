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
  (if (= "cljsjs/highcharts/development/highcharts.inc.js" path)
    {:file-min "cljsjs/highcharts/production/highcharts.min.inc.js"
     :file path
     :provides ["cljsjs.highcharts"]}
    {:file-min path
     :file (-> path
               (string/replace #"\.inc\.js$" ".min.inc.js")
               (string/replace #"/development/" "/production/"))
     :requires ["cljsjs.highcharts"]
     :provides [(-> path
                    (string/replace #"\.inc\.js$" "")
                    (string/replace #"/development/" "/")
                    (string/replace #"/" "."))]}))

(deftask generate-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")]
    (with-pre-wrap
      fileset
      (let [extra-files        (->> fileset c/input-files (c/by-re [#"^cljsjs/highcharts/development/(.*/)?.*\.inc\.js$"]))
            foreign-libs       (map (comp path->foreign-lib c/tmp-path) extra-files)
            new-deps           {:foreign-libs foreign-libs
                                :externs ["cljsjs/highcharts/common/highcharts.ext.js"]}]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url (format "https://code.highcharts.com/zips/Highcharts-%s.zip" +lib-version+)
              :checksum "0402F6D3ADD60DAAA8D8B87643784C2A"
              :unzip true)
    (target)
    (sift :move {#"^code/([^/\.]*)\.js$"      "cljsjs/highcharts/production/$1.min.inc.js"
                 #"^code/([^/\.]*)\.src\.js$" "cljsjs/highcharts/development/$1.inc.js"
                 #"^code/modules/([^/\.]*)\.js$"      "cljsjs/highcharts/production/modules/$1.min.inc.js"
                 #"^code/modules/([^/\.]*)\.src\.js$" "cljsjs/highcharts/development/modules/$1.inc.js"})
    (target)
    (sift :include #{#"^cljsjs"})
    (generate-deps)
    (pom)
    (jar)))
