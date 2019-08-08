(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/svg-intersections
       :version     +version+
       :description "Intersection is a JavaScript object used to capture the results of the intersection of two Shape objects."
       :url         "http://www.quazistax.com/testIntersection.html"
       :scm         {:url "https://github.com/signavio/svg-intersections"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(deftask browserify []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (format "svg-intersections-%s" +lib-version+)))]
        ((sh "npm" "install" "--production"))
        ((sh "npm" "install" "browserify"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "index.js" "--standalone" "SvgIntersections" "-o" "svg-intersections.inc.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download :url (format "https://github.com/signavio/svg-intersections/archive/v%s.zip" +lib-version+)
              :checksum "2DF3780C1177BDD03772CF542E64F1F5"
              :unzip true)

    (browserify)
    (sift :move {#"^svg-intersections(.*)/svg-intersections.inc.js$" "cljsjs/svg-intersections/development/svg-intersections.inc.js"})
    (minify :in "cljsjs/svg-intersections/development/svg-intersections.inc.js"
            :out "cljsjs/svg-intersections/production/svg-intersections.min.inc.js")

    (sift :include  #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.svg-intersections")
    (pom)
    (jar)))
