(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "15.3.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
	 '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "9.4.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/react-google-maps
       :version     +version+
       :description "React.js Google Maps integration component"
       :url         "https://github.com/tomchentw/react-google-maps/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build-react-google-maps []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "react-google-maps-%s" +lib-version+)))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "browserify"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "lib/index.js" "-s" "ReactGoogleMaps" "-o" "react-google-maps.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download
      :url (str "https://github.com/tomchentw/react-google-maps/archive/v" +lib-version+ ".zip")
      :unzip true)

    (build-react-google-maps)

    (sift :move {#"^react-google-maps.*[/ \\]react-google-maps.js$"
                 "cljsjs/react-google-maps/development/react-google-maps.inc.js"})

    #_(minify :in "cljsjs/react-google-maps/development/react-google-maps.inc.js"
        :out "cljsjs/react-google-maps/production/react-google-maps.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs
      :name "cljsjs.react-google-maps"
      :requires ["cljsjs.react" "cljsjs.react.dom"])
    (pom)
    (jar)
    (validate)))
