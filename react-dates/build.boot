(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/moment "2.17.1-0"]
                  [cljsjs/react "15.5.4-1"]
                  [cljsjs/react-dom "15.5.4-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [sh]]
         '[clojure.java.io :as io])

(def +lib-version+ "12.2.4")
(def +version+ (str +lib-version+ "-1"))
(def +lib-folder+ (format "react-dates-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-dates
       :version     +version+
       :description "An accessible, easily internationalizable, mobile-friendly datepicker library for the web."
       :url         "https://github.com/airbnb/react-dates"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/airbnb/react-dates/master/LICENSE"}})

(deftask download-react-dates []
  (download :url      (format "https://github.com/airbnb/react-dates/archive/v%s.zip" +lib-version+)
            :checksum "48c7e7dfbecbeb414085927474af91b1"
            :unzip    true))

(deftask build-react-dates []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap fileset
      (doseq [f (boot/input-files fileset)
              :let [target (io/file tmp (tmpdir/path f))]]
        (io/make-parents target)
        (io/copy (tmpdir/file f) target))
      (io/copy
        (io/file tmp "webpack.config.js")
        (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "autoprefixer"))
        ((sh "npm" "install" "webpack"))
        ((sh "npm" "install" "extract-text-webpack-plugin@^2.0.0-beta"))
        ((sh "npm" "run" "build"))
        ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-react-dates)
    (build-react-dates)
    (sift :move {#".*react-dates.inc.js" "cljsjs/react-dates/development/react-dates.inc.js"
                 #".*_datepicker.css" "cljsjs/react-dates/development/react-dates.inc.css"})
    (sift :include #{#"^cljsjs"})

    (minify :in  "cljsjs/react-dates/development/react-dates.inc.js"
            :out "cljsjs/react-dates/production/react-dates.min.inc.js"
            :lang :ecmascript5)

    (minify :in  "cljsjs/react-dates/development/react-dates.inc.css"
            :out "cljsjs/react-dates/production/react-dates.min.inc.css")

    (deps-cljs :name "cljsjs.react-dates" :requires ["cljsjs.react"
                                                     "cljsjs.moment"
                                                     "cljsjs.react.dom"])

    (pom)
    (jar)))
