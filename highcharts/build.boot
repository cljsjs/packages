(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/highcharts
       :version     +version+
       :description "Create interactive charts easily for your web projects."
       :url         "http://highcharts.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

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
    (jar)
    (validate-checksums)))
